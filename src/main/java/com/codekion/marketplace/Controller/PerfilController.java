package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IHabilidadesService;
import com.codekion.marketplace.Service.IService.ISubCategoriaService;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PerfilController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IHabilidadesService habilidadesService;

    @Autowired
    private ISubCategoriaService subCategoriaService;

    @GetMapping("/perfil/{id}")
    public String irPerfilUsuario(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        List<Habilidade> lstHabilidades = habilidadesService.findHabilidadesByIdUsuario(usuario.getId());
        List<SubCategoria> lstSubCategoria = subCategoriaService.findCategoriasByIdUsuario(usuario.getId());

        UsuarioInfoDto lstUsuario = new UsuarioInfoDto(usuario, lstHabilidades, lstSubCategoria);
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarioInfo", lstUsuario);
        return "pages/perfil-usuario";
    }

}
