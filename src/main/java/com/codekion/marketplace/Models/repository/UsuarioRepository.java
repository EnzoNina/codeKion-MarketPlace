package com.codekion.marketplace.Models.repository;

import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesDTO;
import com.codekion.marketplace.Models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUserAndPass(String user, String pass);

    Usuario findByUser(String username);

    @Query("SELECT NEW com.codekion.marketplace.Models.DTO.UsuarioHabilidadesDTO(u, h,sc) from Usuario u left join UsuariosHabilidade uh on u.id = uh.idUsuario.id left join Habilidade h on uh.idHabilidad.id = h.id right join UsuarioSubCategoria usc on u.id = usc.idUsuario.id right join SubCategoria sc on sc.id = usc.idSubCategoria.id")
    List<UsuarioHabilidadesDTO> buscarUsuariosYHabilidades();



}
