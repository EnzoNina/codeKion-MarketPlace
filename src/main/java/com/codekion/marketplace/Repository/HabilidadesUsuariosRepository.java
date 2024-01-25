package com.codekion.marketplace.Repository;

import com.codekion.marketplace.Models.entity.UsuariosHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadesUsuariosRepository extends JpaRepository<UsuariosHabilidade,Integer> {

}
