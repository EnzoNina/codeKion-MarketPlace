package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesCategoriasDTO;
import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import com.codekion.marketplace.Utils.UsuarioInfoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class ColaboradoresController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/BuscarcolaboradoresPage")
    public String buscarColaboradores(Map<String, Object> model
            , @ModelAttribute("usuario") Usuario sessionUser) {
        // Verificar si el usuario está autenticado
        if (sessionUser == null) {
            // Redirigir al usuario a la página de inicio de sesión
            return "redirect:/login";
        }
        List<UsuarioHabilidadesCategoriasDTO> usuariosList = usuarioService.buscarUsuariosYHabilidades();
        List<UsuarioInfoDto> usuarioInfoList = UsuarioInfoBuilder.buildUsuarioInfoList(usuariosList, sessionUser);
        // Agregar la lista de resultados a los modelos
        model.put("usuarioInfoList", usuarioInfoList);
        return "pages/buscarColaboradores";
    }
}