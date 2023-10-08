package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Colaboradore;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;

import java.util.List;

public interface IColaboradoresService {

    List<Colaboradore> findAll();

}
