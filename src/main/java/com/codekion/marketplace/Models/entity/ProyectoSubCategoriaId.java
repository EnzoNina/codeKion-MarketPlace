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
public class ProyectoSubCategoriaId implements Serializable {
    private static final long serialVersionUID = 8229066572944893975L;
    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    @Column(name = "id_sub_categoria", nullable = false)
    private Integer idSubCategoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProyectoSubCategoriaId entity = (ProyectoSubCategoriaId) o;
        return Objects.equals(this.idProyecto, entity.idProyecto) &&
                Objects.equals(this.idSubCategoria, entity.idSubCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idSubCategoria);
    }

}