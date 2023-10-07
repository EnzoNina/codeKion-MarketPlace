package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuariosSubCategoriasRepository  extends JpaRepository<UsuarioSubCategoria, UsuarioSubCategoriaId> {

     List<UsuarioSubCategoria> findAllByIdIn(List<Integer> ids);


}
