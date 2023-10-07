package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.entity.UsuarioSubCategoria;
import com.codekion.marketplace.Models.entity.UsuarioSubCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuariosSubCategoriasRepository  extends JpaRepository<UsuarioSubCategoria, UsuarioSubCategoriaId> {

     void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> subCategorias);

}
