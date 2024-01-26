package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabilidadesRepository extends JpaRepository<Habilidade, Integer> {

    @Query("select h from Habilidade h inner join UsuariosHabilidade uh on h.id = uh.idHabilidad.id where uh.idUsuario.id =:idUsuario")
    List<Habilidade> findHabilidadesByIdUsuario(Integer idUsuario);

}
