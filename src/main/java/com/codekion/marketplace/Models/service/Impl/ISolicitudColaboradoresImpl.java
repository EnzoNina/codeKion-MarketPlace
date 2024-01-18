package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.repository.SolicitudColaboradoresRepository;
import com.codekion.marketplace.Models.service.IService.ISolicitudColaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISolicitudColaboradoresImpl implements ISolicitudColaboradoresService {

    @Autowired
    private SolicitudColaboradoresRepository solicitudColaboradoresRepository;

    @Override
    public void enviarSolicitud(Proyecto idProyecto, Usuario idUsuario) {
        SolicitudesColaboradore solicitud = new SolicitudesColaboradore();
        solicitud.setIdProyecto(idProyecto);
        solicitud.setIdUsuario(idUsuario);
        solicitudColaboradoresRepository.save(solicitud);
    }
}
