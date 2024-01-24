package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.JefeProyecto;

public interface IJefeProyectoService {

    JefeProyecto findById(Integer id);

    JefeProyecto save(JefeProyecto jefeProyecto);

}
