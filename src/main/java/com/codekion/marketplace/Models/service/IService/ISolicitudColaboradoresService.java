package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;

import java.util.List;

public interface ISolicitudColaboradoresService {

    List<SolicitudesColaboradore> findByIdUsuarioAndEstadoSolicitud(Usuario usuario);

    void enviarSolicitud(Proyecto idProyecto, Usuario idUsuario);

}
