package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.ColaboradoresProyecto;
import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.ProyectoSubCategoria;
import com.codekion.marketplace.Models.entity.ProyectosHabilidade;
import com.codekion.marketplace.Service.IService.IColabores_ProyectosService;
import com.codekion.marketplace.Service.IService.IProyectoHabilidades;
import com.codekion.marketplace.Service.IService.IProyecto_Sub_CategoriaService;
import com.codekion.marketplace.Service.IService.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PerfilProyectoController {

    @Autowired
    private IProyectosService proyectosService;

    @Autowired
    private IProyectoHabilidades proyectoHabilidadesService;

    @Autowired
    private IProyecto_Sub_CategoriaService proyectoSubCategoriaService;

    @Autowired
    private IColabores_ProyectosService colaboradoresProyectosService;

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
