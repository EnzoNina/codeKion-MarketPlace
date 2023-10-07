package com.codekion.marketplace.Models.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotEmpty
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "correo", nullable = false, length = 40)
    private String correo;

    @Column(name = "user", nullable = false, length = 20)
    @NotEmpty
    private String user;

    @Column(name = "pass", nullable = false, length = 20)
    @NotEmpty
    private String pass;

}