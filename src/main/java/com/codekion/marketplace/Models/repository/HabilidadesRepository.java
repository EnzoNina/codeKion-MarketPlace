package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabilidadesRepository  extends JpaRepository<Habilidade,Integer> {

    List<Habilidade> findAllById(List<Integer> ids);
}
