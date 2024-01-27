package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.JefeProyecto;
import com.codekion.marketplace.Models.entity.Usuario;

public interface IJefeProyectoService {

    JefeProyecto findById(Integer id);

    JefeProyecto findByUsuario(Usuario usuario);

    JefeProyecto save(JefeProyecto jefeProyecto);


}
