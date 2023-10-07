package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.repository.HabilidadesRepository;
import com.codekion.marketplace.Models.service.IService.IHabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHabilidadesImpl implements IHabilidadesService {

    @Autowired
    private HabilidadesRepository habilidadesRepository;

    @Override
    public List<Habilidade> findAll() {
        return habilidadesRepository.findAll();
    }
}
