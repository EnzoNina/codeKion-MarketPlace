package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Models.service.IService.IColaboradoresService;
import com.codekion.marketplace.Models.service.IService.IColabores_ProyectosService;
import com.codekion.marketplace.Models.service.IService.ISolicitudColaboradoresService;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notificaciones")
public class SolicitudesController {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(SolicitudesController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ISolicitudColaboradoresService solicitudColaboracionService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IColabores_ProyectosService colaboradoresProyectosService;

    @Autowired
    private IColaboradoresService colaboradoresService;

    @GetMapping("/mostrar")
    public String solicitudes() {
        return "pages/solicitudes";
    }

    @PostMapping("/Buscarcolaboradores")
    public String enviarSolicitudColaboracion(@RequestParam("userId") Integer userId, @RequestParam("proyecto") Proyecto proyecto) {
        Usuario usuario = usuarioService.findById(userId);
        System.out.println("Usuario a enviar solicitud: " + usuario.getUser());
        // Envía una notificación a través de WebSocket
        try {
            solicitudColaboracionService.save(new SolicitudesColaboradore(proyecto, usuario, false));
            messagingTemplate.convertAndSendToUser(usuario.getUser(), "/topic/notificaciones", "Fue invitado para unirse como colaborador al proyecto: " + proyecto.getNombreProyecto());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return "pages/buscarColaboradores";
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
