package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Service.IService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notificaciones")
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
    public String enviarSolicitudColaboracion(@RequestParam("userId") Integer userId, @RequestParam("proyecto") Proyecto proyecto, Model model) {
        Usuario usuario = usuarioService.findById(userId);
        List<Proyecto> lstProyectos = proyectosService.findByColaboradoresAndIdUsuario(usuario.getId());
        if (lstProyectos.isEmpty()) {
            // Envía una notificación a través de WebSocket
            try {
                solicitudColaboracionService.save(new SolicitudesColaboradore(proyecto, usuario, false));
            } catch (DataAccessException e) {
                e.printStackTrace();
            }
        }
        if (lstProyectos.contains(proyecto)) {
            //Retornar a la vista con un mensaje de que el usuario ya esta en el proyecto
            model.addAttribute("error", "El usuario ya esta en el proyecto");
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
        return "redirect:/notificaciones/mostrar";
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
