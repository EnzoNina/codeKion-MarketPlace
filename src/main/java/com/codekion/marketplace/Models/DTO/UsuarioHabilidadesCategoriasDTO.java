package com.codekion.marketplace.Models.DTO;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioHabilidadesCategoriasDTO {

    private Usuario usuario;
    private Habilidade habilidades;
    private SubCategoria sub_categoria;

    public UsuarioHabilidadesCategoriasDTO() {
    }

    public UsuarioHabilidadesCategoriasDTO(Usuario usuario, Habilidade habilidades, SubCategoria sub_categoria) {
        this.usuario = usuario;
        this.habilidades = habilidades;
        this.sub_categoria = sub_categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habilidade getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidade habilidades) {
        this.habilidades = habilidades;
    }

    public SubCategoria getSub_categoria() {
        return sub_categoria;
    }

    public void setSub_categoria(SubCategoria sub_categoria) {
        this.sub_categoria = sub_categoria;
    }
}
