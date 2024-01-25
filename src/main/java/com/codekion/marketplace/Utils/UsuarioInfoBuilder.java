package com.codekion.marketplace.Utils;

import com.codekion.marketplace.Models.DTO.UsuarioDTO;
import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesCategoriasDTO;
import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class UsuarioInfoBuilder {

    public static List<UsuarioInfoDto> buildUsuarioInfoList(List<UsuarioHabilidadesCategoriasDTO> lstUsuario) {
        // Construir mapas usando el método genérico buildMap
        Map<Usuario, List<Habilidade>> usuarioHabilidadesMap = buildMap(lstUsuario, UsuarioHabilidadesCategoriasDTO::getUsuario, UsuarioHabilidadesCategoriasDTO::getHabilidades);
        Map<Usuario, List<SubCategoria>> usuarioSubCategoriasMap = buildMap(lstUsuario, UsuarioHabilidadesCategoriasDTO::getUsuario, UsuarioHabilidadesCategoriasDTO::getSub_categoria);

        // Crear lista final de UsuarioInfoDto
        List<UsuarioInfoDto> infolst = new ArrayList<>();
        for (Usuario usuario : usuarioHabilidadesMap.keySet()) {
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo());
            List<Habilidade> habilidades = usuarioHabilidadesMap.get(usuario);
            List<SubCategoria> subCategorias = usuarioSubCategoriasMap.get(usuario);
            infolst.add(new UsuarioInfoDto(usuarioDTO, habilidades, subCategorias));
        }
        return infolst;
    }

    // Método genérico para construir mapas
    private static <T, U> Map<T, List<U>> buildMap(List<UsuarioHabilidadesCategoriasDTO> lstUsuario, Function<UsuarioHabilidadesCategoriasDTO, T> keyExtractor, Function<UsuarioHabilidadesCategoriasDTO, U> valueExtractor) {
        Map<T, List<U>> usuarioMap = new HashMap<>();

        // Iterar sobre la lista de UsuarioHabilidadesCategoriasDTO
        for (UsuarioHabilidadesCategoriasDTO dto : lstUsuario) {
            // Obtener la clave y el valor utilizando los extractores de función
            T key = keyExtractor.apply(dto);
            U value = valueExtractor.apply(dto);

            // Obtener o crear la lista de valores para la clave
            List<U> values = usuarioMap.computeIfAbsent(key, k -> new ArrayList<>());

            // Verificar si el valor ya existe en la lista antes de agregarlo
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        return usuarioMap;
    }
}
