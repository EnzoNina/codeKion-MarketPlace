package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

//@ControllerAdvice permite aplicar ciertos comportamientos a todos los controladores
@ControllerAdvice
public class GlobalControllerAdvice {

    //Clase para obtener el usuario de la sesion en cualquier controlador
    @ModelAttribute("usuario")
    public Usuario getUsuario(HttpSession session) {
        return (Usuario) session.getAttribute("usuario");
    }

}
