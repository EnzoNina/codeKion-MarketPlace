package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.entity.UsuarioSubCategoria;
import com.codekion.marketplace.Models.entity.UsuarioSubCategoriaId;

import java.util.List;

public interface ISub_Categorias_UsuariosService {

    UsuarioSubCategoria findById(UsuarioSubCategoriaId idUsuario);

    void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> subCategorias);

}
