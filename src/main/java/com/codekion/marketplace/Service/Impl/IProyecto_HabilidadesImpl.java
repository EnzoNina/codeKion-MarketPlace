package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;
import com.codekion.marketplace.Models.entity.ProyectosHabilidadeId;
import com.codekion.marketplace.Repository.Proyecto_HabilidadesRepository;
import com.codekion.marketplace.Service.IService.IProyecto_HabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProyecto_HabilidadesImpl implements IProyecto_HabilidadesService {

    @Autowired
    private Proyecto_HabilidadesRepository proyectoHabilidadesRepository;

    @Override
    public List<ProyectosHabilidade> findAllByProyecto(Proyecto id) {
        return proyectoHabilidadesRepository.findAllByIdProyecto(id);
    }

    @Override
    public void saveProyectoHabilidades(Proyecto proyecto, List<Habilidade> lstHabilidades) {
        for (Habilidade habilidad : lstHabilidades) {
            ProyectosHabilidade proyectosHabilidade = new ProyectosHabilidade();
            proyectosHabilidade.setId(new ProyectosHabilidadeId(proyecto.getId(), habilidad.getId()));
            proyectosHabilidade.setIdProyecto(proyecto);
            proyectosHabilidade.setIdHabilidad(habilidad);
            proyectoHabilidadesRepository.save(proyectosHabilidade);
        }
    }
}
