package com.codekion.marketplace.Models.service.Impl;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.entity.UsuariosHabilidade;
import com.codekion.marketplace.Models.entity.UsuariosHabilidadeId;
import com.codekion.marketplace.Models.repository.HabilidadesRepository;
import com.codekion.marketplace.Models.repository.HabilidadesUsuariosRepository;
import com.codekion.marketplace.Models.service.IService.IHabilidadesUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHabilidadesUsuariosImpl implements IHabilidadesUsuariosService {

    @Autowired
    private HabilidadesUsuariosRepository habilidadesUsuariosRepository;
    @Autowired
    private HabilidadesRepository habilidadesRepository;

    @Override
    public List<UsuariosHabilidade> findAll() {
        return habilidadesUsuariosRepository.findAll();
    }

    @Override
    public List<UsuariosHabilidade> findAllByIds(Usuario usuario, List<Integer> ids) {

        List<Habilidade> lst = habilidadesRepository.findAll();

        return lst.stream()
                .filter(x -> ids.contains(x.getId()))
                .map(x -> new UsuariosHabilidade(usuario, x))
                .toList();

    }

    @Override
    public void saveHabilidadesUsuarios(Usuario usuario, List<Habilidade> lstHabilidades) {
        for (Habilidade habilidade : lstHabilidades) {
            UsuariosHabilidade usuariosHabilidade = new UsuariosHabilidade();
            usuariosHabilidade.setId(new UsuariosHabilidadeId(usuario.getId(), habilidade.getId()));
            usuariosHabilidade.setIdUsuario(usuario);
            usuariosHabilidade.setIdHabilidad(habilidade);
            habilidadesUsuariosRepository.save(usuariosHabilidade);
        }
    }
}
