package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsuarioSubCategoriaId implements Serializable {
    public UsuarioSubCategoriaId() {

    }
    //Constructor para el ID
    public UsuarioSubCategoriaId(Integer idUsuario, Integer idSubCategoria) {
        this.idUsuario = idUsuario;
        this.idSubCategoria = idSubCategoria;
    }

    private static final long serialVersionUID = 1601671012791139664L;
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_sub_categoria", nullable = false)
    private Integer idSubCategoria;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioSubCategoriaId entity = (UsuarioSubCategoriaId) o;
        return Objects.equals(this.idSubCategoria, entity.idSubCategoria) &&
                Objects.equals(this.idUsuario, entity.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubCategoria, idUsuario);
    }

}