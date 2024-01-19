package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.ColaboradoresProyecto;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.repository.ColaboresProyectosRepository;
import com.codekion.marketplace.Models.service.IService.IColabores_ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IColabores_ProyectosImpl implements IColabores_ProyectosService {

    @Autowired
    private ColaboresProyectosRepository colaboresProyectosRepository;

    @Override
    public List<ColaboradoresProyecto> findAllByIdProyecto(Proyecto proyecto) {
        return colaboresProyectosRepository.findAllByIdProyecto(proyecto);
    }
}
