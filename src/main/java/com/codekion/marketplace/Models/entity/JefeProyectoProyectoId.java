package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class JefeProyectoProyectoId implements Serializable {
    private static final long serialVersionUID = -2821116190548922912L;
    @Column(name = "id_jefe_proyecto", nullable = false)
    private Integer idJefeProyecto;

    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    public JefeProyectoProyectoId() {
    }

    public JefeProyectoProyectoId(Integer idJefeProyecto, Integer idProyecto) {
        this.idJefeProyecto = idJefeProyecto;
        this.idProyecto = idProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JefeProyectoProyectoId entity = (JefeProyectoProyectoId) o;
        return Objects.equals(this.idProyecto, entity.idProyecto) &&
                Objects.equals(this.idJefeProyecto, entity.idJefeProyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idJefeProyecto);
    }

}