package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesCategoriasDTO;
import com.codekion.marketplace.Models.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioService extends UserDetailsService {

    public Usuario findByUserAndPass(String user, String pass);

    public List<Usuario> findAll();

    public Usuario save(Usuario usuario);

    public Usuario findById(Integer id);

    Usuario findByUser(String user);

    public List<UsuarioHabilidadesCategoriasDTO> buscarUsuariosYHabilidades();

    public List<UsuarioHabilidadesCategoriasDTO> UsuarioHabilidadesCategoriasDTOPorIdUsuario(Integer idUsuario);

}
