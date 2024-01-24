package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.ColaboradoresProyecto;
import com.codekion.marketplace.Models.entity.ColaboradoresProyectoId;
import com.codekion.marketplace.Models.entity.Proyecto;

import java.util.List;

public interface IColabores_ProyectosService {

    ColaboradoresProyecto findById(ColaboradoresProyectoId id);

    ColaboradoresProyecto save(ColaboradoresProyecto colaboradoresProyecto);

    List<ColaboradoresProyecto> findAllByIdProyecto(Proyecto proyecto);

}
