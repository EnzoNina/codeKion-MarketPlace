package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;

import java.util.List;

public interface IProyecto_HabilidadesService {
    List<ProyectosHabilidade> findAllByProyecto(Proyecto id);
    void saveProyectoHabilidades(Proyecto proyecto, List<Habilidade> lstHabilidades);
}
