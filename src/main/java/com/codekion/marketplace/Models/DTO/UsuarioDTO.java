package com.codekion.marketplace.Models.DTO;

import com.codekion.marketplace.Models.entity.Habilidade;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private List<Habilidade> habilidades;

}
