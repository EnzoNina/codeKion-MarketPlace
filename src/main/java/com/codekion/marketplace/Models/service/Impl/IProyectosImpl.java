package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.DTO.UsuarioProyectoDTO;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.repository.ProyectoRepository;
import com.codekion.marketplace.Models.service.IService.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class IProyectosImpl implements IProyectosService {

    @Autowired
    private ProyectoRepository proyectoRepository;


    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }


    @Override
    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto findById(Integer id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> findByJefeProyecto(Integer id) {
        System.out.println("HOLAAAAAAAAAAAAAAAAA" +id);
        List<UsuarioProyectoDTO> lstDTO = proyectoRepository.buscarProyectosPorUsuario();


        List<Proyecto> lstProyectos = new ArrayList<>();
        //Hacemos un for para recorrer la lista de DTO y obtener los proyectos que pertenecen al usuario con el id que se le pasa por parametro
        lstDTO.forEach(dto -> {
            if (Objects.equals(dto.getUsuario().getId(), id)) {
                lstProyectos.add(dto.getProyectos());
            }
        });
        return lstProyectos;
    }


}