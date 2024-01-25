package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;
import com.codekion.marketplace.Models.entity.ProyectosHabilidadeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectoHabilidadesRepository extends JpaRepository<ProyectosHabilidade, ProyectosHabilidadeId> {
    List<ProyectosHabilidade> findAllByIdProyecto(Proyecto IdProyecto);
}