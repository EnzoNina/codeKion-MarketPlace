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

    //Se esta utilizando en buscarColaboradores.html en el script del ajax
    @GetMapping("/getProyectosPorUsuario")
    @ResponseBody
    public List<Proyecto> getProyectosPorUsuario(@ModelAttribute("usuario") Usuario usuario) {
        return proyectosService.findByJefeProyecto(usuario.getId());
    }

    @GetMapping("/getProyectos")
    @ResponseBody
    public List<Proyecto> getProyectos() {
        return proyectosService.findAll();
    }

    @GetMapping("/BuscarProyectos")
    public String buscarProyectos(Model model) {
        return "pages/buscarProyectos";
    }


}
