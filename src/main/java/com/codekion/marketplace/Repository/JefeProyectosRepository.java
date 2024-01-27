package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.JefeProyecto;
import com.codekion.marketplace.Models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JefeProyectosRepository extends JpaRepository<JefeProyecto, Integer> {

    JefeProyecto findByIdUsuario(Usuario usuarioId);

}
