package com.codekion.marketplace.Service.Impl;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.entity.UsuariosHabilidade;
import com.codekion.marketplace.Models.entity.UsuariosHabilidadeId;
import com.codekion.marketplace.Repository.HabilidadesRepository;
import com.codekion.marketplace.Repository.HabilidadesUsuariosRepository;
import com.codekion.marketplace.Service.IService.IHabilidadesUsuariosService;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHabilidadesUsuariosImpl implements IHabilidadesUsuariosService {

    @Autowired
    private HabilidadesUsuariosRepository habilidadesUsuariosRepository;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public List<UsuariosHabilidade> findAll() {
        return habilidadesUsuariosRepository.findAll();
    }


    @Override
    public void saveHabilidadesUsuarios(Usuario usuario, List<Habilidade> lstHabilidades) {

        Usuario originalUsuario = usuarioService.findByUser(usuario.getUser());

        for (Habilidade habilidade : lstHabilidades) {
            UsuariosHabilidade usuariosHabilidade = new UsuariosHabilidade();
            usuariosHabilidade.setId(new UsuariosHabilidadeId(originalUsuario.getId(), habilidade.getId()));
            usuariosHabilidade.setIdUsuario(originalUsuario);
            usuariosHabilidade.setIdHabilidad(habilidade);
            habilidadesUsuariosRepository.save(usuariosHabilidade);
        }
    }
}
