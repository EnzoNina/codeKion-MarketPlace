package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios_habilidades")
public class UsuariosHabilidade {

    @EmbeddedId
    private UsuariosHabilidadeId id;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @MapsId("idHabilidad")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habilidad", nullable = false)
    private Habilidade idHabilidad;

    public UsuariosHabilidade(Usuario usuario, Habilidade x) {
        this.idUsuario = usuario;
        this.idHabilidad = x;
    }

    public UsuariosHabilidade() {

    }

    public UsuariosHabilidadeId getId() {
        return id;
    }

    public void setId(UsuariosHabilidadeId id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Habilidade getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Habilidade idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}