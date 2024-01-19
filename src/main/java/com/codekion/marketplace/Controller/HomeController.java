package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Models.service.IService.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IProyectosService proyectosService;

    @Autowired
    private ISubCategoriaService subCategoriaService;

    @Autowired
    private IProyectoHabilidades proyectoHabilidadesService;

    @Autowired
    private IProyecto_Sub_CategoriaService proyectoSubCategoriaService;

    @Autowired
    private IColabores_ProyectosService colaboradoresProyectosService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {

            List<Proyecto> lstProyectos = proyectosService.findAll();

            List<SubCategoria> lstCategorias = subCategoriaService.findAll();
            model.addAttribute("proyectos", lstProyectos);
            model.addAttribute("subcategorias", lstCategorias);
            // Agrega el usuario al modelo para que esté disponible en la vista
            model.addAttribute("usuario", usuario);

            return "pages/home";
        } else {
            // Manejar el caso en el que el usuario no está autenticado
            return "redirect:/login"; // Por ejemplo, redirige a la página de inicio de sesión
        }
    }

    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("usuario");
        return "redirect:/";
    }

    @GetMapping("/perfil")
    public String irPerfil() {
        return "pages/perfil-usuario";
    }

    @GetMapping("/perfilProyecto/{id}")
    public String irProyectos(@PathVariable("id") Integer id, Model model) {
        Proyecto proyecto = proyectosService.findById(id);
        List<ProyectosHabilidade> lstProyectosHabilidades = proyectoHabilidadesService.findAllByProyecto(proyecto);
        List<ProyectoSubCategoria> lstProyectoSubCategoria = proyectoSubCategoriaService.findAllByProyecto(proyecto);
        List<ColaboradoresProyecto> lstColaboresProyectos = colaboradoresProyectosService.findAllByIdProyecto(proyecto);
        model.addAttribute("proyectoHabilidades", lstProyectosHabilidades);
        model.addAttribute("lstProyectSubCategoria", lstProyectoSubCategoria);
        model.addAttribute("lstColaboresProyectos", lstColaboresProyectos);
        model.addAttribute("proyecto", proyecto);
        //Falta agregar a los colaboradores
        return "pages/perfil-proyecto";
    }
}
