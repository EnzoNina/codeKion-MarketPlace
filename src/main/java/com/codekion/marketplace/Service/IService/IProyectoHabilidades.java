package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;

import java.util.List;

public interface IProyectoHabilidades {
    List<ProyectosHabilidade> findAllByProyecto(Proyecto id);
}
