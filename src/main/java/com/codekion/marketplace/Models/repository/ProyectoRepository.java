package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.DTO.UsuarioProyectoDTO;
import com.codekion.marketplace.Models.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    @Query("SELECT NEW com.codekion.marketplace.Models.DTO.UsuarioProyectoDTO(u,p) from Usuario u left join JefeProyecto jp on u.id = jp.idUsuario.id left join JefeProyectoProyecto  jpp on jp.id = jpp.idJefeProyecto.idUsuario.id left join Proyecto p on jpp.idProyecto.id = p.id")
    List<UsuarioProyectoDTO> buscarProyectosPorUsuario();

}
