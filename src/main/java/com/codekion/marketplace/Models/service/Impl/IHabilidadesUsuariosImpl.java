package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.UsuariosHabilidade;
import com.codekion.marketplace.Models.repository.HabilidadesUsuariosRepository;
import com.codekion.marketplace.Models.service.IService.IHabilidadesUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHabilidadesUsuariosImpl implements IHabilidadesUsuariosService {

    @Autowired
    private HabilidadesUsuariosRepository habilidadesUsuariosRepository;

    @Override
    public List<UsuariosHabilidade> findAll() {
        return habilidadesUsuariosRepository.findAll();
    }

    @Override
    public List<UsuariosHabilidade> findAllByIdIn(List<Integer> ids) {

        List<UsuariosHabilidade> lst = habilidadesUsuariosRepository.findAll();

        return lst.stream().filter(x -> ids.contains(x.getId())).toList();

    }
}
