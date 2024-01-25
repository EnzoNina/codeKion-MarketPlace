package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PerfilController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/perfil/{id}")
    public String irPerfilUsuario(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.findById(id);

        model.addAttribute("usuario", usuario);
        return "pages/perfil-usuario";
    }

}
