package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Config.WebSecurity;
import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesCategoriasDTO;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Repository.UsuarioRepository;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        usuario.setPass(WebSecurity.passwordEncoder.encode(usuario.getPass()));
        return usuarioDao.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUser(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getUser(), usuario.getPass(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Override
    public Optional findById(Integer id) {
        return usuarioDao.findById(id);
    }

    @Override
    public Usuario findByUser(String user) {
        return usuarioDao.findByUser(user);
    }

    public List<UsuarioHabilidadesCategoriasDTO> buscarUsuariosYHabilidades() {
        return usuarioDao.buscarUsuariosYHabilidades();
    }

    @Override
    public Page<UsuarioHabilidadesCategoriasDTO> buscarUsuariosYHabilidadesPageable(Pageable pageable) {
        return usuarioDao.buscarUsuariosYHabilidadesPageable(pageable);
    }

}