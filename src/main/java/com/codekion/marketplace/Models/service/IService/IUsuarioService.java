package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario findByUserAndPass(String user, String pass);

    public List<Usuario> findAll();
    public Usuario save(Usuario usuario);
    public Usuario findById(Integer id);

}
