package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.DTO.UsuarioProyectoDTO;
import com.codekion.marketplace.Models.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    @Query("SELECT p FROM Proyecto p left join JefeProyectoProyecto jpp on p.id=jpp.idProyecto.id " +
            "left join JefeProyecto jp on jpp.idJefeProyecto.id_jefe_proyecto = jp.id_jefe_proyecto " +
            "left join Usuario u on jp.idUsuario.id=u.id where u.id =:idUsuario")
            List<Proyecto>findByJefeProyecto(Integer idUsuario);

    @Query("Select p FROM Proyecto p left join ColaboradoresProyecto cp on p.id = cp.idProyecto.id " +
            "left join Colaboradore c on cp.idColaborador.id = c.id left join Usuario u on c.idUsuario.id = u.id where u.id =:idUsuario")
    List<Proyecto> findByColaboradoresAndIdUsuario(Integer idUsuario);
}
