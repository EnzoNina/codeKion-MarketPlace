package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "habilidades")
public class Habilidade {
    @Id
    @Column(name = "id_habilidad", nullable = false)
    private Integer id;

    @Column(name = "nombre_habilidad", nullable = false, length = 20)
    private String nombreHabilidad;

}