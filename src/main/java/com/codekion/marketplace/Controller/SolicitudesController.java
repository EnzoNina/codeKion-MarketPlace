package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.ISolicitudColaboradoresService;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/solicitudes")
public class SolicitudesController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ISolicitudColaboradoresService solicitudColaboracionService;

    @Autowired
    private IUsuarioService usuarioService;
    // Lista de usuarios conectados
    private Set<String> connectedUsers = new HashSet<>();

    @PostMapping("/Buscarcolaboradores")
    public ResponseEntity<String> enviarSolicitudColaboracion(@RequestParam("userId") Integer userId, @RequestParam("proyecto") Proyecto proyecto) {
        Usuario usuario = usuarioService.findById(userId);
        // Envía una notificación a través de WebSocket
        enviarNotificacionGlobal(usuario);
        solicitudColaboracionService.enviarSolicitud(proyecto, usuario);
        return ResponseEntity.ok("Solicitud enviada con éxito");
    }

    @MessageMapping("/chat/notificaciones")
    public void enviarNotificacion(Usuario principal) {
        // Lógica para manejar solicitudes WebSocket
        messagingTemplate.convertAndSendToUser(principal.getId().toString(), "/chat/notificaciones", "Tiene una nueva solicitud de colaboración");
    }
    @MessageMapping("/chat/notificacion-global")
    public void enviarNotificacionGlobal(Usuario principal) {
        String username = principal.getNombre();
        // Verifica si el usuario ya está en la lista de conectados
        if (connectedUsers.add(username)) {
            // Envía notificación a todos los usuarios conectados
            messagingTemplate.convertAndSend("/topic/notificacion-global", "Nueva notificación global de " + username);
        }
    }
}
