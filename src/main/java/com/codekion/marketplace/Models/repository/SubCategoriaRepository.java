package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoriaRepository  extends JpaRepository<SubCategoria, Integer> {

    @Query("select s from SubCategoria s where s.id =:ids")
    List<SubCategoria> findByIdIn(List<Integer> ids);

}
