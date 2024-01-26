package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Habilidade;

import java.util.List;

public interface IHabilidadesService {

    List<Habilidade> findAll();

    List<Habilidade> findByIds(List<Integer> habilidadesiD);

    List<Habilidade> findHabilidadesByIdUsuario(Integer idUsuario);
}
