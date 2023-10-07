package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsuariosHabilidadeId implements Serializable {
    private static final long serialVersionUID = -7372714889850262922L;
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_habilidad", nullable = false)
    private Integer idHabilidad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuariosHabilidadeId entity = (UsuariosHabilidadeId) o;
        return Objects.equals(this.idUsuario, entity.idUsuario) &&
                Objects.equals(this.idHabilidad, entity.idHabilidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idHabilidad);
    }

}