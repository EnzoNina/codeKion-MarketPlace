package com.codekion.marketplace.Models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "solicitudes_colaboradores")
public class SolicitudesColaboradore {
    @Id
    @Column(name = "id_solicitud", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_proyecto", nullable = false)
    private Proyecto idProyecto;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "estado_solicitud", nullable = true)
    private Boolean estadoSolicitud = false;

    public SolicitudesColaboradore() {
    }

    public SolicitudesColaboradore(Proyecto idProyecto, Usuario idUsuario, Boolean estadoSolicitud) {
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.estadoSolicitud = estadoSolicitud;
    }

    @Override
    public String toString() {
        return "SolicitudesColaboradore{" +
                "id=" + id +
                ", idProyecto=" + idProyecto +
                ", idUsuario=" + idUsuario +
                ", estadoSolicitud=" + estadoSolicitud +
                '}';
    }
}