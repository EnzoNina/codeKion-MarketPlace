package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.JefeProyecto;
import com.codekion.marketplace.Models.entity.JefeProyectoProyecto;
import com.codekion.marketplace.Models.entity.JefeProyectoProyectoId;

import java.util.List;

public interface IJefeProyectoProyectosService {

    JefeProyectoProyecto findByJefeProyecto(JefeProyectoProyectoId id);

    JefeProyectoProyecto save(JefeProyectoProyecto jefeProyectoProyecto);

}
