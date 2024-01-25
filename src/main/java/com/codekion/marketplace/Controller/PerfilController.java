package com.codekion.marketplace.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {
    @GetMapping("/perfil")
    public String irPerfil() {
        return "pages/perfil-usuario";
    }

    @GetMapping("/perfil-usuario")
    public String irPerfilUsuario() {
        return "pages/perfil-usuario";
    }

}
