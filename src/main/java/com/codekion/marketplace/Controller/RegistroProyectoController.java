package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Service.IService.*;
import com.codekion.marketplace.Utils.ModelPostFormBuilder;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class RegistroProyectoController {
    @Autowired
    private IJefeProyectoService jefeProyectoService;

    @Autowired
    private IJefeProyectoProyectosService jefeProyectoProyectosService;

    @Autowired
    private IProyectosService proyectosService;

    @Autowired
    private IHabilidadesService habilidadesService;

    @Autowired
    private ISubCategoriaService subCategoriaService;

    @Autowired
    private IProyecto_HabilidadesService proyectoHabilidadesService;

    @Autowired
    private IProyecto_Sub_CategoriaService proyectoSubCategoriaService;

    ModelPostFormBuilder modelPostFormBuilder = new ModelPostFormBuilder();

    @GetMapping("/Crearproyecto")
    public String proyecto(Map<String, Object> model) {
        model.put("proyecto", new Proyecto());
        return "pages/crearProyecto";
    }

    @PostMapping("/Crearproyecto")
    public String proyectoPost(@Valid Proyecto proyecto, HttpSession session, Map<String, Object> model) {
        try {
            //Obtenemos el objeto proyecto a la session
            session.setAttribute("proyecto", proyecto);
            //Agregamos las listas al modelo
            modelPostFormBuilder.ListHabilitiesAndSubCategoriesBuilder(model, habilidadesService, subCategoriaService);
            return "pages/postFormProyecto";
        } catch (Exception e) {
            return "redirect:/home";
        }
    }

    @PostMapping("/registrarPostFormProyecto")
    public String postForm(@RequestParam("habilidades") List<Integer> habilidadesiD, @RequestParam("subcategorias") List<Integer> subCategoriasIds, HttpSession session, @ModelAttribute("usuario") Usuario usuario) {
        //Obtenemos el objeto Proyecto de la sesion
        Proyecto proyecto = (Proyecto) session.getAttribute("proyecto");
        //Obtenemos las listas de habilidades y subcategorias
        List<Habilidade> lstHabilidades = habilidadesService.findByIds(habilidadesiD);
        List<SubCategoria> lstSubCategorias = subCategoriaService.findByIds(subCategoriasIds);
        //Guardamos el proyecto y el jefe de proyecto
        saveProyectoAndJefeProyecto(proyecto, usuario);
        //Guardamos las habilidades y subcategorias del proyecto
        proyectoHabilidadesService.saveProyectoHabilidades(proyecto, lstHabilidades);
        proyectoSubCategoriaService.saveProyectoSubCategorias(proyecto, lstSubCategorias);
        return "redirect:/home";
    }

    private void saveProyectoAndJefeProyecto(Proyecto proyecto, Usuario usuario) {
        //Creamos instancia de tipo JefeProyecto
        JefeProyecto jefeProyecto = jefeProyectoService.findByUsuario(usuario);
        if (jefeProyecto == null) {
            jefeProyecto = new JefeProyecto();

        }
        jefeProyecto.setIdUsuario(usuario);
        //Obtenemos el objeto creado ya que este contiene el ID
        JefeProyecto jefeProyectoSaved = jefeProyectoService.save(jefeProyecto);
        //Obtenemos el ID del objeto Proyecto
        Proyecto proyectoSaved = proyectosService.save(proyecto);
        //Creamos la instancia de JefeProyectoProyecto y le asignamos los valores
        JefeProyectoProyecto jefeProyectoProyecto = new JefeProyectoProyecto();
        jefeProyectoProyecto.setId(new JefeProyectoProyectoId(jefeProyectoSaved.getId_jefe_proyecto(), proyectoSaved.getId()));
        jefeProyectoProyecto.setIdJefeProyecto(jefeProyectoSaved);
        jefeProyectoProyecto.setIdProyecto(proyectoSaved);
        //Guardamos la instancia de JefeProyectoProyecto
        jefeProyectoProyectosService.save(jefeProyectoProyecto);
    }

}