package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.UsuariosHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabilidadesUsuariosRepository extends JpaRepository<UsuariosHabilidade,Integer> {

}
