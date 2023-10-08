package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesDTO;
import com.codekion.marketplace.Models.repository.UsuarioRepository;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUsuarioImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioDao;

    @Override
    public Usuario findByUserAndPass(String user, String pass) {
        return usuarioDao.findByUserAndPass(user, pass);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioHabilidadesDTO> buscarUsuariosYHabilidades() {
        return usuarioDao.buscarUsuariosYHabilidades();
    }
}