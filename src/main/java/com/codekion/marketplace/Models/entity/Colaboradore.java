package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "colaboradores")
public class Colaboradore {

    @Id
    @Column(name = "id_colaborador", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    //Constructor
    public Colaboradore() {
    }

    public Colaboradore(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}