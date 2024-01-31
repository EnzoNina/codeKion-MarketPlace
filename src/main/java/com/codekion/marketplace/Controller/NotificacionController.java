package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.ISolicitudColaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NotificacionController {

    @Autowired
    private ISolicitudColaboradoresService solicitudColaboracionService;

    @GetMapping("/getNumeroNotificaciones")
    @ResponseBody
    public int getNumeroNotificaciones(@ModelAttribute("usuario") Usuario usuario) {
        List<SolicitudesColaboradore> lstSolicitudes = solicitudColaboracionService.findByIdUsuarioAndEstadoSolicitud(usuario);
        if (lstSolicitudes == null)
            return 0;

        return lstSolicitudes.size();
    }

}
