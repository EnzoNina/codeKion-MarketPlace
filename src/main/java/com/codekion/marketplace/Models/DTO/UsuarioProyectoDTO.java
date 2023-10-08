package com.codekion.marketplace.Models.DTO;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;

import java.util.List;

public class UsuarioProyectoDTO {

    private Usuario usuario;
    private Proyecto proyecto;

    public UsuarioProyectoDTO() {
    }

    public UsuarioProyectoDTO(Usuario usuario, Proyecto proyecto) {
        this.usuario = usuario;
        this.proyecto = proyecto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proyecto getProyectos() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
