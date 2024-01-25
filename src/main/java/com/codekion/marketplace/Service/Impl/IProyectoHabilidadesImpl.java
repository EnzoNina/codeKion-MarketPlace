package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;
import com.codekion.marketplace.Repository.ProyectoHabilidadesRepository;
import com.codekion.marketplace.Service.IService.IProyectoHabilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProyectoHabilidadesImpl implements IProyectoHabilidades {

    @Autowired
    private ProyectoHabilidadesRepository proyectoHabilidadesRepository;

    @Override
    public List<ProyectosHabilidade> findAllByProyecto(Proyecto id) {
        return proyectoHabilidadesRepository.findAllByIdProyecto(id);
    }
}
