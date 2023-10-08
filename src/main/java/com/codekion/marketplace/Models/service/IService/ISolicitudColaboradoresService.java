package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;

public interface ISolicitudColaboradoresService {

    void enviarSolicitud(Proyecto idProyecto, Usuario idUsuario);

}
