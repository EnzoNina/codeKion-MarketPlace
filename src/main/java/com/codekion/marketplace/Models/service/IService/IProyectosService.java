package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;

import java.util.List;

public interface IProyectosService {

    List<Proyecto> findAll();


    public Proyecto save(Proyecto proyecto);

    public Proyecto findById(Integer id);

    List<Proyecto> findByJefeProyecto(Integer id);


}
