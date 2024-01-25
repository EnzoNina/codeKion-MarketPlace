package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.SubCategoria;

import java.util.List;

public interface ISubCategoriaService {

    public List<SubCategoria> findAll();

    public List<SubCategoria> findByIds(List<Integer> ids);

}
