package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @Column(name = "id_categoria", nullable = false)
    @NotEmpty
    private Integer id;

    @NotEmpty
    @Column(name = "nombre_categoria", nullable = false, length = 50)
    private String nombreCategoria;

}