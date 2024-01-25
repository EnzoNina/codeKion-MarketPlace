package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.ColaboradoresProyecto;
import com.codekion.marketplace.Models.entity.ColaboradoresProyectoId;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Repository.ColaboradoresProyectosRepository;
import com.codekion.marketplace.Service.IService.IColabores_ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IColabores_ProyectosImpl implements IColabores_ProyectosService {

    @Autowired
    private ColaboradoresProyectosRepository colaboresProyectosRepository;

    @Override
    public ColaboradoresProyecto findById(ColaboradoresProyectoId id) {
        return colaboresProyectosRepository.findById(id).orElse(null);
    }

    @Override
    public ColaboradoresProyecto save(ColaboradoresProyecto colaboradoresProyecto) {
        return colaboresProyectosRepository.save(colaboradoresProyecto);
    }

    @Override
    public List<ColaboradoresProyecto> findAllByIdProyecto(Proyecto proyecto) {
        return colaboresProyectosRepository.findAllByIdProyecto(proyecto);
    }
}
