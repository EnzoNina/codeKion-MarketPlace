package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Service.IService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {
    @Autowired
    private ISolicitudColaboradoresService solicitudColaboracionService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IColabores_ProyectosService colaboradoresProyectosService;

    @Autowired
    private IColaboradoresService colaboradoresService;

    @Autowired
    private IProyectosService proyectosService;

    @GetMapping("/mostrar")
    public String solicitudes() {
        return "pages/solicitudes";
    }

    @PostMapping("/enviarSolicitud")
    public String enviarSolicitudColaboracion(@RequestParam("userId") Integer userId
            , @RequestParam("proyecto") Proyecto proyecto
            , RedirectAttributes redirectAttributes) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(userId);

        try {
            Usuario usuario = usuarioOptional.orElseThrow(NullPointerException::new);
            List<Proyecto> lstProyectos = proyectosService.findByColaboradoresAndIdUsuario(usuario.getId());
            //Obtener las solicitudes del usuario
            List<SolicitudesColaboradore> lstSolicitudesColaboradores = solicitudColaboracionService.findByIdUsuarioAndEstadoSolicitud(usuario);
            //Verificamos si la solicitud ya se encuentra en la base de datos
            Boolean solicitudEnviada = lstSolicitudesColaboradores.stream().anyMatch(solicitud -> solicitud.getIdProyecto().getId().equals(proyecto.getId()));
            //Verificar Si el proyecto ya fue aceptado por el usuario
            if (lstProyectos.contains(proyecto)) {
                redirectAttributes.addFlashAttribute("error", "El usuario ya esta en el proyecto");
                return "redirect:/BuscarcolaboradoresPage";
            }
            //Verificar si el usuario ya envió una solicitud
            if (!solicitudEnviada) {
                try {
                    solicitudColaboracionService.save(new SolicitudesColaboradore(proyecto, usuario, false));
                } catch (DataAccessException e) {
                    redirectAttributes.addFlashAttribute("error", "Error al enviar la solicitud: " + e.getMessage());
                    return "pages/errorPage";

                }
            } else {
                redirectAttributes.addFlashAttribute("error", "El usuario ya tiene una solicitud enviada para este proyecto");
            }
        } catch (NullPointerException e) {
            redirectAttributes.addFlashAttribute("error", "Error al enviar la solicitud: " + e.getMessage());
            return "redirect:/login";
        }
        return "redirect:/BuscarcolaboradoresPage";
    }

    @GetMapping("/getNotificaciones")
    @ResponseBody
    public List<SolicitudesColaboradore> getNotificaciones(@ModelAttribute("usuario") Usuario usuario) {
        return solicitudColaboracionService.findByIdUsuarioAndEstadoSolicitud(usuario);
    }

    @GetMapping("/aceptarSolicitud/{id}")
    public String aceptarSolicitud(@PathVariable("id") Integer id) {
        try {
            //Actualizamos el estado de la solicitud a 1 que significa aceptada
            SolicitudesColaboradore solicitud = solicitudColaboracionService.findById(id);
            solicitud.setEstadoSolicitud(true);
            SolicitudesColaboradore solicitudUpdate = solicitudColaboracionService.save(solicitud);
            //Buscamos el colaborador
            Colaboradore colaborador = getColaboradore(solicitudUpdate);
            //Creamos el ID de la tabla colaboradores_proyectos
            ColaboradoresProyectoId colaboradoresProyectoId = new ColaboradoresProyectoId(solicitudUpdate.getIdProyecto().getId(), colaborador.getId());
            //Creamos y guardamos en la base de datos el colaborador del proyecto
            ColaboradoresProyecto colaboradoresProyecto = new ColaboradoresProyecto(colaboradoresProyectoId, solicitudUpdate.getIdProyecto(), colaborador);
            colaboradoresProyectosService.save(colaboradoresProyecto);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/solicitudes/mostrar";
    }

    //Obtenemos el colaborador o lo creamos si no existe
    private Colaboradore getColaboradore(SolicitudesColaboradore solicitudUpdate) {
        Colaboradore colaborador = colaboradoresService.findByUsuario(solicitudUpdate.getIdUsuario());
        if (colaborador == null) {
            colaborador = colaboradoresService.save(new Colaboradore(solicitudUpdate.getIdUsuario()));
        }
        return colaborador;
    }

}
