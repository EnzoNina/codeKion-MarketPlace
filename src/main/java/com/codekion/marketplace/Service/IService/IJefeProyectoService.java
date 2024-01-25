package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.JefeProyecto;

public interface IJefeProyectoService {

    JefeProyecto findById(Integer id);

    JefeProyecto save(JefeProyecto jefeProyecto);

}
