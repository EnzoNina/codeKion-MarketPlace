package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import java.util.List;

public interface ISolicitudColaboradoresService {

    SolicitudesColaboradore findById(Integer id);

    List<SolicitudesColaboradore> findByIdUsuarioAndEstadoSolicitud(Usuario usuario);

    SolicitudesColaboradore save(SolicitudesColaboradore solicitud);
}
