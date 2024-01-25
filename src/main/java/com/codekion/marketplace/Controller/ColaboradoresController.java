package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioDTO;
import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesDTO;
import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ColaboradoresController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/Buscarcolaboradores")
    public String buscarCreadores(Map<String, Object> model) {
        // Obtener la lista de todos los usuarios y habilidades
        List<UsuarioHabilidadesDTO> lstUsuario = usuarioService.buscarUsuariosYHabilidades();

        // Crear mapas utilizando los métodos separados
        Map<Usuario, List<Habilidade>> usuarioHabilidadesMap = buildUsuarioHabilidadesMap(lstUsuario);
        Map<Usuario, List<SubCategoria>> usuarioSubCategoriasMap = buildUsuarioSubCategoriasMap(lstUsuario);

        // Envía un List<UsuarioInfoDto> que tiene UsuarioDTO, habilidad y subCategoria
        model.put("usuarioInfoList", buildUsuarioInfoList(usuarioHabilidadesMap, usuarioSubCategoriasMap));

        return "pages/buscarColaboradores";
    }

    // Método para construir el mapa de Usuario y Habilidades
    private Map<Usuario, List<Habilidade>> buildUsuarioHabilidadesMap(List<UsuarioHabilidadesDTO> lstUsuario) {
        Map<Usuario, List<Habilidade>> usuarioHabilidadesMap = new HashMap<>();

        for (UsuarioHabilidadesDTO dto : lstUsuario) {
            Usuario usuario = dto.getUsuario();
            Habilidade habilidad = dto.getHabilidades();

            // Obtener o crear la lista de habilidades para este usuario
            List<Habilidade> habilidades = usuarioHabilidadesMap.computeIfAbsent(usuario, k -> new ArrayList<>());

            // Verificar si la habilidad ya existe en la lista antes de agregarla
            if (!habilidades.contains(habilidad)) {
                habilidades.add(habilidad);
            }
        }

        return usuarioHabilidadesMap;
    }

    private Map<Usuario, List<SubCategoria>> buildUsuarioSubCategoriasMap(List<UsuarioHabilidadesDTO> lstUsuario) {
        Map<Usuario, List<SubCategoria>> usuarioSubCategoriasMap = new HashMap<>();

        for (UsuarioHabilidadesDTO dto : lstUsuario) {
            Usuario usuario = dto.getUsuario();
            SubCategoria subCategoria = dto.getSub_categoria();

            // Obtener o crear la lista de subcategorías para este usuario
            List<SubCategoria> subCategorias = usuarioSubCategoriasMap.computeIfAbsent(usuario, k -> new ArrayList<>());

            // Verificar si la subcategoría ya existe en la lista antes de agregarla
            if (!subCategorias.contains(subCategoria)) {
                subCategorias.add(subCategoria);
            }
        }

        return usuarioSubCategoriasMap;
    }

    // Método para construir la lista final de UsuarioInfoDto
    private List<UsuarioInfoDto> buildUsuarioInfoList(Map<Usuario, List<Habilidade>> usuarioHabilidadesMap, Map<Usuario, List<SubCategoria>> usuarioSubCategoriasMap) {
        //Podriamos cambiar para que UsuarioInfoDto no tenga Usuario y tenga UsuarioDTO
        List<UsuarioInfoDto> infolst = new ArrayList<>();
        for (Usuario usuario : usuarioHabilidadesMap.keySet()) {
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo());
            List<Habilidade> habilidades = usuarioHabilidadesMap.get(usuario);
            List<SubCategoria> subCategorias = usuarioSubCategoriasMap.get(usuario);
            infolst.add(new UsuarioInfoDto(usuarioDTO, habilidades, subCategorias));
        }
        return infolst;
    }

}