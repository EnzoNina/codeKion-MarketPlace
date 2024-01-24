package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jefe_proyecto")
public class JefeProyecto {
    @Id
    @Column(name = "id_jefe_proyecto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_jefe_proyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}