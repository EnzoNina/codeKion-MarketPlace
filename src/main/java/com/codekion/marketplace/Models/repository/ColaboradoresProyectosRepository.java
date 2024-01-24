package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.ColaboradoresProyecto;
import com.codekion.marketplace.Models.entity.ColaboradoresProyectoId;
import com.codekion.marketplace.Models.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColaboradoresProyectosRepository extends JpaRepository<ColaboradoresProyecto, ColaboradoresProyectoId> {

    List<ColaboradoresProyecto> findAllByIdProyecto(Proyecto proyecto);

}