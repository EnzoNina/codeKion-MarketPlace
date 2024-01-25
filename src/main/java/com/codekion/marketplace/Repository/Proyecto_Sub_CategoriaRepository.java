package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectoSubCategoria;
import com.codekion.marketplace.Models.entity.ProyectoSubCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Proyecto_Sub_CategoriaRepository extends JpaRepository<ProyectoSubCategoria, ProyectoSubCategoriaId> {

    List<ProyectoSubCategoria> findAllByIdProyecto(Proyecto proyectoId);

}
