package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.JefeProyectoProyecto;
import com.codekion.marketplace.Models.entity.JefeProyectoProyectoId;

public interface IJefeProyectoProyectosService {

    JefeProyectoProyecto findByJefeProyecto(JefeProyectoProyectoId id);

    JefeProyectoProyecto save(JefeProyectoProyecto jefeProyectoProyecto);

}
