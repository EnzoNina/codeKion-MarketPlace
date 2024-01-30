package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;

import java.util.List;

public interface IProyectosService {

    List<Proyecto> findAll();

    Proyecto save(Proyecto proyecto);

    Proyecto findById(Integer id);

    List<Proyecto> findByJefeProyecto(Integer id);


}
