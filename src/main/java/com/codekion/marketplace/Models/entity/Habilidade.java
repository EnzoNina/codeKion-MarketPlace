package com.codekion.marketplace.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "habilidades")
public class Habilidade {
    @Id
    @Column(name = "id_habilidad", nullable = false)
    private Integer id;

    @Column(name = "nombre_habilidad", nullable = false, length = 50)
    private String nombreHabilidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }
}