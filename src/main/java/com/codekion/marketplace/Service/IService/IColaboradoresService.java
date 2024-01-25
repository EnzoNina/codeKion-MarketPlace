package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Colaboradore;
import com.codekion.marketplace.Models.entity.Usuario;

import java.util.List;

public interface IColaboradoresService {

    Colaboradore save(Colaboradore colaborador);

    Colaboradore findByUsuario(Usuario usuario);

    List<Colaboradore> findAll();

}
