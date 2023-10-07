package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Habilidade;

import java.util.List;

public interface IHabilidadesService {

    public List<Habilidade> findAll();

    public List<Habilidade> findByIds(List<Integer> ids);

}
