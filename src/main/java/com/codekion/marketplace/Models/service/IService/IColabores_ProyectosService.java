package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.ColaboradoresProyecto;
import com.codekion.marketplace.Models.entity.Proyecto;

import java.util.List;

public interface IColabores_ProyectosService {

    List<ColaboradoresProyecto> findAllByIdProyecto(Proyecto proyecto);

}
