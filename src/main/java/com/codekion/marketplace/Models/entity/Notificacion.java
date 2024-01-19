package com.codekion.marketplace.Models.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notificacion {

    private Usuario destinatario;
    private String mensaje;
    private LocalDateTime fecha;

}
