package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Repository.SolicitudColaboradoresRepository;
import com.codekion.marketplace.Service.IService.ISolicitudColaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISolicitudColaboradoresImpl implements ISolicitudColaboradoresService {

    @Autowired
    private SolicitudColaboradoresRepository solicitudColaboradoresRepository;

    @Override
    public SolicitudesColaboradore findById(Integer id) {
        return solicitudColaboradoresRepository.findById(id).orElse(null);
    }

    @Override
    public List<SolicitudesColaboradore> findByIdUsuarioAndEstadoSolicitud(Usuario usuario) {
        return solicitudColaboradoresRepository.findByIdUsuarioAndEstadoSolicitud(usuario, false);
    }

    @Override
    public SolicitudesColaboradore save(SolicitudesColaboradore solicitud) {
        return solicitudColaboradoresRepository.save(solicitud);
    }
}
