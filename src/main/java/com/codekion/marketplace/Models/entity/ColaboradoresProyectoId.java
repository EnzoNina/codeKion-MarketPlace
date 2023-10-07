package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ColaboradoresProyectoId implements Serializable {
    private static final long serialVersionUID = 5300888847522807946L;
    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    @Column(name = "id_colaborador", nullable = false)
    private Integer idColaborador;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ColaboradoresProyectoId entity = (ColaboradoresProyectoId) o;
        return Objects.equals(this.idProyecto, entity.idProyecto) &&
                Objects.equals(this.idColaborador, entity.idColaborador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idColaborador);
    }

}