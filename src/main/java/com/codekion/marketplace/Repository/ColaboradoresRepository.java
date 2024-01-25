package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.Colaboradore;
import com.codekion.marketplace.Models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradoresRepository extends JpaRepository<Colaboradore, Integer> {

    Colaboradore findByIdUsuario(Usuario usuario);

}
