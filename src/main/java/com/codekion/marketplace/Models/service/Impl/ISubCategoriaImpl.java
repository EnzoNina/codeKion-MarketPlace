package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.repository.SubCategoriaRepository;
import com.codekion.marketplace.Models.service.IService.ISubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
       return subCategoriaRepository.findByIdIn(ids);
    }
}
