package com.codekion.marketplace.Models.service.IService;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.entity.UsuariosHabilidade;

import java.util.List;

public interface IHabilidadesUsuariosService {

    public List<UsuariosHabilidade> findAll();

    public List<UsuariosHabilidade> findAllByIds(Usuario usuario, List<Integer> ids);

    void saveHabilidadesUsuarios(Usuario usuario, List<Habilidade> lstHabilidades);
}
