package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoriaRepository  extends JpaRepository<SubCategoria, Integer> {

    List<SubCategoria> findAllByIdIn(List<Integer> ids);

}
