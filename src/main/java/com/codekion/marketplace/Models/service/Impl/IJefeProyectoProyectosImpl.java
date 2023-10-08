package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.JefeProyecto;
import com.codekion.marketplace.Models.repository.IJefeProyectosRepository;
import com.codekion.marketplace.Models.service.IService.IJefeProyectoProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IJefeProyectoProyectosImpl implements IJefeProyectoProyectosService {

    @Autowired
    private IJefeProyectosRepository jefeProyectosRepository;

    @Override
    public List<JefeProyecto> findByJefeProyecto() {
        return null;
    }
}
