package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Service.IService.IJefeProyectoProyectosService;
import com.codekion.marketplace.Service.IService.IJefeProyectoService;
import com.codekion.marketplace.Service.IService.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ProyectoController {

    @Autowired
    private IProyectosService proyectosService;

    @Autowired
    private IJefeProyectoService jefeProyectoService;

    @Autowired
    private IJefeProyectoProyectosService jefeProyectoProyectosService;

    //Se esta utilizando en buscarColaboradores.html en el script del ajax
    @GetMapping("/getProyectos")
    @ResponseBody
    public List<Proyecto> getProyectos(@ModelAttribute("usuario") Usuario usuario) {
        return proyectosService.findByJefeProyecto(usuario.getId());
    }

    @GetMapping("/Crearproyecto")
    public String proyecto(Map<String, Object> model) {
        model.put("proyecto", new Proyecto());
        return "pages/crearProyecto";
    }

    @PostMapping("/Crearproyecto")
    public String proyectoPost(@Valid Proyecto proyecto, Model model, BindingResult result, @ModelAttribute("usuario") Usuario usuario) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Error de Proyecto");
            return "redirect:/home";
        } else {
            try {
                //Creamos instancia de tipo JefeProyecto
                JefeProyecto jefeProyecto = new JefeProyecto();
                jefeProyecto.setIdUsuario(usuario);
                //Obtenemos el objeto creado ya que este contiene el ID
                JefeProyecto jefeProyectoSaved = jefeProyectoService.save(jefeProyecto);
                //Obtenemos el ID del objeto Proyecto
                Proyecto proyectoSaved = proyectosService.save(proyecto);
                JefeProyectoProyecto jefeProyectoProyecto = new JefeProyectoProyecto();
                jefeProyectoProyecto.setId(new JefeProyectoProyectoId(jefeProyectoSaved.getId_jefe_proyecto(), proyectoSaved.getId()));
                jefeProyectoProyecto.setIdJefeProyecto(jefeProyectoSaved);
                jefeProyectoProyecto.setIdProyecto(proyectoSaved);
                jefeProyectoProyectosService.save(jefeProyectoProyecto);
            } catch (Exception e) {
                model.addAttribute("titulo", "Error de Proyecto");
                return "redirect:/home";
            }
            return "redirect:/home";
        }
    }

}
