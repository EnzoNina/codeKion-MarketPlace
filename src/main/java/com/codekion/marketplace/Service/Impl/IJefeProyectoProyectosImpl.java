package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.JefeProyectoProyecto;
import com.codekion.marketplace.Models.entity.JefeProyectoProyectoId;
import com.codekion.marketplace.Repository.JefeProyectos_Proyectos_Repository;
import com.codekion.marketplace.Service.IService.IJefeProyectoProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IJefeProyectoProyectosImpl implements IJefeProyectoProyectosService {

    @Autowired
    private JefeProyectos_Proyectos_Repository jefeProyectoProyectosRepository;

    @Override
    public JefeProyectoProyecto findByJefeProyecto(JefeProyectoProyectoId id) {
        return jefeProyectoProyectosRepository.findById(id).orElse(null);
    }

    @Override
    public JefeProyectoProyecto save(JefeProyectoProyecto jefeProyectoProyecto) {
        return jefeProyectoProyectosRepository.save(jefeProyectoProyecto);
    }
}
