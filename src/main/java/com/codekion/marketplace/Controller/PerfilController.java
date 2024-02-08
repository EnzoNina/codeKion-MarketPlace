package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IHabilidadesService;
import com.codekion.marketplace.Service.IService.ISubCategoriaService;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class PerfilController {
    Logger logger = org.slf4j.LoggerFactory.getLogger(PerfilController.class);

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IHabilidadesService habilidadesService;

    @Autowired
    private ISubCategoriaService subCategoriaService;

    @GetMapping("/perfil/{id}")
    public String irPerfilUsuario(@PathVariable Integer id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        try {
            Usuario usuario = usuarioOptional.orElseThrow(() -> new NoSuchElementException("El usuario no existe"));
            List<Habilidade> lstHabilidades = habilidadesService.findHabilidadesByIdUsuario(usuario.getId());
            List<SubCategoria> lstSubCategoria = subCategoriaService.findCategoriasByIdUsuario(usuario.getId());
            UsuarioInfoDto lstUsuario = new UsuarioInfoDto(usuario, lstHabilidades, lstSubCategoria);
            model.addAttribute("usuario", usuario);
            model.addAttribute("usuarioInfo", lstUsuario);
            return "pages/perfil-usuario";
        } catch (NoSuchElementException e) {
            // Manejar la excepción y redirigir a la página de error
            logger.error("Error: " + e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "pages/errorPage";
        }

    }

}
