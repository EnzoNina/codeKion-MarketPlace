package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.ISolicitudColaboradoresService;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/notificaciones")
public class SolicitudesController {

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
}
