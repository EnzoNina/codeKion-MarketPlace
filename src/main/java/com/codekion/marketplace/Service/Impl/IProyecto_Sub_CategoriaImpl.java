package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectoSubCategoria;
import com.codekion.marketplace.Repository.Proyecto_Sub_CategoriaRepository;
import com.codekion.marketplace.Service.IService.IProyecto_Sub_CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProyecto_Sub_CategoriaImpl implements IProyecto_Sub_CategoriaService {

    @Autowired
    private Proyecto_Sub_CategoriaRepository proyecto_sub_categoriaRepository;

    @Override
    public List<ProyectoSubCategoria> findAllByProyecto(Proyecto proyectoId) {
        return proyecto_sub_categoriaRepository.findAllByIdProyecto(proyectoId);
    }
}
