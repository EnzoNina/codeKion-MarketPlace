package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @Column(name = "id_proyecto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_proyecto", nullable = false, length = 1000)
    private String nombreProyecto;

    @Lob
    @Column(name = "url_proyecto", nullable = false)
    private String urlProyecto;

    @Lob
    @Column(name = "descripcion_proyecto", nullable = false)
    private String descripcionProyecto;

    @Lob
    @Column(name = "estado_proyecto", nullable = false)
    private String estadoProyecto;

}