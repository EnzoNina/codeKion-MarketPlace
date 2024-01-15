package com.codekion.marketplace.Models.DTO;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class UsuarioProyectoDTO {

    private Usuario usuario;
    private Proyecto proyecto;

    public UsuarioProyectoDTO() {
    }

    public UsuarioProyectoDTO(Usuario usuario, Proyecto proyecto) {
        this.usuario = usuario;
        this.proyecto = proyecto;
    }


}
