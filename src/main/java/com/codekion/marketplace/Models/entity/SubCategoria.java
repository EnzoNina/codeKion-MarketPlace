package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_categorias")
public class SubCategoria {
    @Id
    @Column(name = "id_sub_categoria", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria idCategoria;

    @Column(name = "nombre_sub_categoria", nullable = false, length = 50)
    private String nombreSubCategoria;

}