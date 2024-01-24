package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.Colaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.repository.ColaboradoresRepository;
import com.codekion.marketplace.Models.service.IService.IColaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IColaboradoresImpl implements IColaboradoresService {

    @Autowired
    private ColaboradoresRepository colaboradoresRepository;

    @Override
    public Colaboradore findByUsuario(Usuario usuario) {
        return colaboradoresRepository.findByIdUsuario(usuario);
    }

    @Override
    public List<Colaboradore> findAll() {
        return colaboradoresRepository.findAll();
    }


}
