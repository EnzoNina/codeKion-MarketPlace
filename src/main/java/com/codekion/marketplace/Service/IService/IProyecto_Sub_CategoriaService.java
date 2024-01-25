package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectoSubCategoria;

import java.util.List;

public interface IProyecto_Sub_CategoriaService {

    List<ProyectoSubCategoria> findAllByProyecto(Proyecto proyecto);

}
