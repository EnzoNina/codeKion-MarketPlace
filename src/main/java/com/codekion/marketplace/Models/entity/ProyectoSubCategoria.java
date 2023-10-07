package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proyecto_sub_categorias")
public class ProyectoSubCategoria {
    @EmbeddedId
    private ProyectoSubCategoriaId id;

    @MapsId("idProyecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proyecto", nullable = false)
    private Proyecto idProyecto;

    @MapsId("idSubCategoria")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sub_categoria", nullable = false)
    private SubCategoria idSubCategoria;

}