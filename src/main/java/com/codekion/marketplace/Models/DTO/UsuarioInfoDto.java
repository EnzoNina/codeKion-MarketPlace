package com.codekion.marketplace.Models.DTO;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;

import java.util.List;

public class UsuarioInfoDto {

    private Usuario usuario;
    private List<Habilidade> habilidades;
    private List<SubCategoria> subCategorias;

    public UsuarioInfoDto() {
    }

    public UsuarioInfoDto(Usuario usuario, List<Habilidade> habilidades, List<SubCategoria> subCategorias) {
        this.usuario = usuario;
        this.habilidades = habilidades;
        this.subCategorias = subCategorias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }

    @Override
    public String toString() {
        return "UsuarioInfoDto{" +
                "usuario=" + usuario.toString() +
                ", habilidades=" + habilidades.toString() +
                ", subCategorias=" + subCategorias.toString() +
                '}';
    }
}
