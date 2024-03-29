package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoriaRepository  extends JpaRepository<SubCategoria, Integer> {

    @Query("select s from SubCategoria s where s.id IN :ids")
    List<SubCategoria> findByIdIn(List<Integer> ids);

    @Query("select s from SubCategoria s inner join UsuarioSubCategoria usc on s.id = usc.idSubCategoria.id where usc.idUsuario.id = :id")
    List<SubCategoria> findCategoriasByIdUsuario(Integer id);

}
