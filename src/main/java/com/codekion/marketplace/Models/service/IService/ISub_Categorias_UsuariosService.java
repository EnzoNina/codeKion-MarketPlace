package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.*;

import java.util.List;

public interface ISub_Categorias_UsuariosService {

    UsuarioSubCategoria findById(UsuarioSubCategoriaId idUsuario);


    void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> subCategorias);

    List<UsuarioSubCategoria> findByIDs(Usuario usuario, List<Integer> subCategoriasIds);
}
