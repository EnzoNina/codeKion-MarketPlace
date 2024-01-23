package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Config.WebSecurity;
import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesDTO;
import com.codekion.marketplace.Models.repository.UsuarioRepository;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        Usuario newUsuario = new Usuario();
        newUsuario.setNombre(usuario.getNombre());
        newUsuario.setApellido(usuario.getApellido());
        newUsuario.setUser(usuario.getUser());
        newUsuario.setCorreo(usuario.getCorreo());
        newUsuario.setPass(WebSecurity.passwordEncoder.encode(usuario.getPass()));
        return usuarioDao.save(newUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("El username pasado es: " + username);
        Usuario usuario = usuarioDao.findByUser(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getUser(), usuario.getPass(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public Usuario findByUser(String user) {
        return usuarioDao.findByUser(user);
    }

    @Override
    public List<UsuarioHabilidadesDTO> buscarUsuariosYHabilidades() {
        return usuarioDao.buscarUsuariosYHabilidades();
    }
}