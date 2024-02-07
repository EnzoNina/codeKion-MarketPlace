package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Proyecto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProyectosService {

    List<Proyecto> findAll();

    Page<Proyecto> findAllPageable(Pageable pageable);

    Page<Proyecto> findAllPageableByNombreAndIgnoreUpperCase(String searchValue, Pageable pageable);

    Proyecto save(Proyecto proyecto);

    Proyecto findById(Integer id);

    List<Proyecto> findByJefeProyecto(Integer id);

    List<Proyecto> findByColaboradoresAndIdUsuario(Integer idUsuario);
}
