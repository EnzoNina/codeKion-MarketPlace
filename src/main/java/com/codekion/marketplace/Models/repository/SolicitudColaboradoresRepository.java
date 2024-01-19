package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.SolicitudesColaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudColaboradoresRepository extends JpaRepository<SolicitudesColaboradore, Integer> {

    List<SolicitudesColaboradore> findByIdUsuarioAndEstadoSolicitud(Usuario idUsuario, Boolean estadoSolicitud);

}
