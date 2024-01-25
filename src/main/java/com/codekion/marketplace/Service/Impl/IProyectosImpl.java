package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.DTO.UsuarioProyectoDTO;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Repository.ProyectoRepository;
import com.codekion.marketplace.Service.IService.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<UsuarioProyectoDTO> lstDTO = proyectoRepository.buscarProyectosPorUsuario(id);
        //Con UsuarioProyectoDTO::getProyectos obtenemos los proyectos que pertenecen al usuario con el id que se le pasa por parametro
        List<Proyecto> lstProyectos = lstDTO.stream().map(UsuarioProyectoDTO::getProyecto).toList();
        return lstProyectos;
    }


}
