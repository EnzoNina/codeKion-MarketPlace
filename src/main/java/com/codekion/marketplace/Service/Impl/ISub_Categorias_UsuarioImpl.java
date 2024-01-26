package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Repository.UsuariosSubCategoriasRepository;
import com.codekion.marketplace.Service.IService.ISub_Categorias_UsuariosService;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ISub_Categorias_UsuarioImpl implements ISub_Categorias_UsuariosService {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private UsuariosSubCategoriasRepository usuariosSubCategoriasRepository;

    @Override
    public UsuarioSubCategoria findById(UsuarioSubCategoriaId idUsuario) {
        return usuariosSubCategoriasRepository.findById(idUsuario).orElse(null);
    }


    @Override
    @Transactional
    public void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> lstsubCategorias) {

        Usuario originalUsuario = usuarioService.findByUser(usuario.getUser());

        for (SubCategoria subCategoria : lstsubCategorias) {
            UsuarioSubCategoria usuarioSubCategoria = new UsuarioSubCategoria();
            usuarioSubCategoria.setId(new UsuarioSubCategoriaId(originalUsuario.getId(), subCategoria.getId()));
            usuarioSubCategoria.setIdUsuario(originalUsuario);
            usuarioSubCategoria.setIdSubCategoria(subCategoria);
            usuariosSubCategoriasRepository.save(usuarioSubCategoria);
        }

    }

}
