package com.codekion.marketplace.Security;

import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private IUsuarioService usuarioService;

    public CustomAuthenticationSuccessHandler(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Usuario usuario = usuarioService.findByUser(authentication.getName());
        session.setAttribute("usuario", usuario);
        response.sendRedirect("/home");
    }
}
