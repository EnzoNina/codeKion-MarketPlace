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
    public String buscarCreadores(Map<String, Object> model, @ModelAttribute("usuario") Usuario sessionUser) {

        List<UsuarioHabilidadesCategoriasDTO> lstUsuario = usuarioService.buscarUsuariosYHabilidades();

        // Envía un List<UsuarioInfoDto> que tiene UsuarioDTO, habilidad y subCategoria
        List<UsuarioInfoDto> lstUsuarioUInfoDTO = UsuarioInfoBuilder.buildUsuarioInfoList(lstUsuario, sessionUser);
        model.put("usuarioInfoList", lstUsuarioUInfoDTO);

        return "pages/buscarColaboradores";
    }


}