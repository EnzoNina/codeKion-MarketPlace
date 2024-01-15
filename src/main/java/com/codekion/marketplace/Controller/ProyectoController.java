package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.service.IService.IProyectosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ProyectoController {

    @Autowired
    private IProyectosService proyectosService;

    //Se esta utilizando en buscarColaboradores.html en el script del ajax
    @GetMapping("/getProyectos")
    @ResponseBody
    public List<Proyecto> getProyectos(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Proyecto> lst = proyectosService.findByJefeProyecto(usuario.getId());
        return lst;
    }

    @GetMapping("/Crearproyecto")
    public String proyecto(Map<String, Object> model) {
        model.put("proyecto", new Proyecto());
        return "pages/crearProyecto";
    }

    @PostMapping("/Crearproyecto")
    public String proyectoPost(@Valid Proyecto proyecto, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Error de Proyecto");
            return "redirect:/home";
        } else {
            proyectosService.save(proyecto);
            return "redirect:/home";
        }
    }

}
