package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.ISolicitudColaboradoresService;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/notificaciones")
public class SolicitudesController {

    private HttpSession session;

    Usuario usuarioSession = (Usuario) session.getAttribute("usuario");

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ISolicitudColaboradoresService solicitudColaboracionService;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/Buscarcolaboradores")
    public String enviarSolicitudColaboracion(@RequestParam("userId") Integer userId, @RequestParam("proyecto") Proyecto proyecto) {
        Usuario usuario = usuarioService.findById(userId);
        System.out.println("Usuario a enviar solicitud: " + usuario.getUser());
        // Envía una notificación a través de WebSocket
        try {
            solicitudColaboracionService.enviarSolicitud(proyecto, usuario);
            messagingTemplate.convertAndSendToUser(usuario.getUser(), "/topic/notificaciones", "Fue invitado para unirse como colaborador al proyecto: " + proyecto.getNombreProyecto());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return "pages/buscarColaboradores";
    }

    @GetMapping("/getNotificaciones")
    @ResponseBody
    public List<SolicitudesColaboradore> getNotificaciones(@RequestParam("userId") Integer userId) {
        return solicitudColaboracionService.findByIdUsuarioAndEstadoSolicitud(usuarioSession);
    }

}
