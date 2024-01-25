package com.codekion.marketplace.Security;

import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private IUsuarioService usuarioService;

    public CustomAuthenticationSuccessHandler(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    Logger log = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        log.info("El usuario '" + authentication.getName() + "' ha iniciado sesión con éxito");
        Usuario usuario = usuarioService.findByUser(authentication.getName());
        session.setAttribute("usuario", usuario);
        response.sendRedirect("/home");
    }
}
