package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.SubCategoria;

import java.util.List;

public interface ISubCategoriaService {

    List<SubCategoria> findAll();

    List<SubCategoria> findByIds(List<Integer> ids);

    List<SubCategoria> findCategoriasByIdUsuario(Integer id);

}
