package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jefe_proyecto_proyectos")
public class JefeProyectoProyecto {
    @EmbeddedId
    private JefeProyectoProyectoId id;

    @MapsId("idJefeProyecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_jefe_proyecto", nullable = false)
    private JefeProyecto idJefeProyecto;

    @MapsId("idProyecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proyecto", nullable = false)
    private Proyecto idProyecto;

}