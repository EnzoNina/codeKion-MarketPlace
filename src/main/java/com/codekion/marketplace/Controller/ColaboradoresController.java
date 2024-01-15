package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioDTO;
import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesDTO;
import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Colaboradore;
import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.IColaboradoresService;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class ColaboradoresController {

    @Autowired
    private IColaboradoresService colaboradoresService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/Buscarcolaboradores")
    public String buscarCreadores(Map<String, Object> model) {

        List<UsuarioHabilidadesDTO> lstUsuario = usuarioService.buscarUsuariosYHabilidades();

        // Crear un mapa para agrupar las habilidades y subcategorías por usuario
        Map<Usuario, List<Habilidade>> usuarioHabilidadesMap = new HashMap<>();
        Map<Usuario, List<SubCategoria>> usuarioSubCategoriasMap = new HashMap<>();

        for (UsuarioHabilidadesDTO dto : lstUsuario) {
            Usuario usuario = dto.getUsuario();
            Habilidade habilidad = dto.getHabilidades();
            SubCategoria subCategoria = dto.getSub_categoria();

            // Obtener o crear la lista de habilidades y subcategorías para este usuario
            List<Habilidade> habilidades = usuarioHabilidadesMap.computeIfAbsent(usuario, k -> new ArrayList<>());
            List<SubCategoria> subCategorias = usuarioSubCategoriasMap.computeIfAbsent(usuario, k -> new ArrayList<>());

            // Verificar si la habilidad o subcategoría ya existe en la lista antes de agregarla
            if (!habilidades.contains(habilidad)) {
                habilidades.add(habilidad);
            }

            if (!subCategorias.contains(subCategoria)) {
                subCategorias.add(subCategoria);
            }
        }

        // Envía un List<UsuarioInfoDto> que tiene Usuario, habilidad y subCategoria
        model.put("usuarioInfoList", buildUsuarioInfoList(usuarioHabilidadesMap, usuarioSubCategoriasMap));

        return "pages/buscarColaboradores";
    }

    @PostMapping("/Buscarcolaboradores")
    public String enviarSolicitud() {
        return "redirect:/home";
    }


    // Método para construir la lista final de UsuarioInfoDto
    private List<UsuarioInfoDto> buildUsuarioInfoList(Map<Usuario, List<Habilidade>> usuarioHabilidadesMap, Map<Usuario, List<SubCategoria>> usuarioSubCategoriasMap) {
        List<UsuarioInfoDto> infolst = new ArrayList<>();
        for (Usuario usuario : usuarioHabilidadesMap.keySet()) {
            List<Habilidade> habilidades = usuarioHabilidadesMap.get(usuario);
            List<SubCategoria> subCategorias = usuarioSubCategoriasMap.get(usuario);
            infolst.add(new UsuarioInfoDto(usuario, habilidades, subCategorias));
        }
        return infolst;
    }

}



