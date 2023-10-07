package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Models.repository.SubCategoriaRepository;
import com.codekion.marketplace.Models.repository.UsuariosSubCategoriasRepository;
import com.codekion.marketplace.Models.service.IService.ISub_Categorias_UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ISub_Categorias_UsuarioImpl implements ISub_Categorias_UsuariosService {

    @Autowired
    private UsuariosSubCategoriasRepository usuariosSubCategoriasRepository;

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    @Override
    public UsuarioSubCategoria findById(UsuarioSubCategoriaId idUsuario) {
        return usuariosSubCategoriasRepository.findById(idUsuario).orElse(null);
    }


    @Override
    @Transactional
    public void saveCategoriasUsuarios(Usuario usuario, List<SubCategoria> lstsubCategorias) {

        for (SubCategoria subCategoria : lstsubCategorias) {
            UsuarioSubCategoria usuarioSubCategoria = new UsuarioSubCategoria();
            usuarioSubCategoria.setId(new UsuarioSubCategoriaId(usuario.getId(), subCategoria.getId()));
            usuarioSubCategoria.setIdUsuario(usuario);
            usuarioSubCategoria.setIdSubCategoria(subCategoria);
            usuariosSubCategoriasRepository.save(usuarioSubCategoria);
        }

    }

    @Override
    public List<UsuarioSubCategoria> findByIDs(Usuario usuario, List<Integer> subCategoriasIds) {

        List<SubCategoria> lst = subCategoriaRepository.findAll();

        return lst.stream()
                .filter(x -> subCategoriasIds.contains(x.getId()))
                .map(x -> new UsuarioSubCategoria(usuario, x))
                .toList();

    }
}
