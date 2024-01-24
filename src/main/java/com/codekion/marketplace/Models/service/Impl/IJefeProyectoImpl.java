package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.JefeProyecto;
import com.codekion.marketplace.Models.repository.JefeProyectosRepository;
import com.codekion.marketplace.Models.service.IService.IJefeProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IJefeProyectoImpl implements IJefeProyectoService {

    @Autowired
    private JefeProyectosRepository jefeProyectoRepository;


    @Override
    public JefeProyecto findById(Integer id) {
        return jefeProyectoRepository.findById(id).orElse(null);
    }

    @Override
    public JefeProyecto save(JefeProyecto jefeProyecto) {
        return jefeProyectoRepository.save(jefeProyecto);
    }
}
