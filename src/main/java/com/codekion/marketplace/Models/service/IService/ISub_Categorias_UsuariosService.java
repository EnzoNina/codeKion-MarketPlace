package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.*;

import java.util.List;

public interface ISub_Categorias_UsuariosService {

    UsuarioSubCategoria findById(UsuarioSubCategoriaId idUsuario);

    public List<UsuarioSubCategoria> findAllByIdIn(List<Integer> ids);

    void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> subCategorias);

}
