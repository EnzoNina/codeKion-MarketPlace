package com.codekion.marketplace.Service.IService;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.entity.UsuariosHabilidade;

import java.util.List;

public interface IHabilidadesUsuariosService {

    public List<UsuariosHabilidade> findAll();

    void saveHabilidadesUsuarios(Usuario usuario, List<Habilidade> lstHabilidades);
}
