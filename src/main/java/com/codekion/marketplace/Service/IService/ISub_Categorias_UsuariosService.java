package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.*;

import java.util.List;

public interface ISub_Categorias_UsuariosService {

    UsuarioSubCategoria findById(UsuarioSubCategoriaId idUsuario);

    void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> subCategorias);

}
