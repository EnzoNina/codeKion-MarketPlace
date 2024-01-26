package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Repository.SubCategoriaRepository;
import com.codekion.marketplace.Service.IService.ISubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISubCategoriaImpl implements ISubCategoriaService {

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    @Override
    public List<SubCategoria> findAll() {
        return subCategoriaRepository.findAll();
    }

    @Override
    public List<SubCategoria> findByIds(List<Integer> ids) {
        //List<SubCategoria> lstSCategorias = subCategoriaRepository.findAll();
        //return lstSCategorias.stream().filter(sub_categoria->ids.contains(sub_categoria.getId())).toList();
        return subCategoriaRepository.findByIdIn(ids);
    }

    @Override
    public List<SubCategoria> findCategoriasByIdUsuario(Integer id) {
        return subCategoriaRepository.findCategoriasByIdUsuario(id);
    }
}
