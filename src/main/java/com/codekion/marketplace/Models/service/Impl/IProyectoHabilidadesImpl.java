package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;
import com.codekion.marketplace.Models.repository.ProyectoHabilidadesRepository;
import com.codekion.marketplace.Models.service.IService.IProyectoHabilidades;
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
