package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUserAndPass(String user, String pass);

}
