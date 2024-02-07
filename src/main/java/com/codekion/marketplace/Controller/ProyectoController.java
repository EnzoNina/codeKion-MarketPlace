package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Proyecto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public Page<Proyecto> getProyectos(@RequestParam("start") int start,
                                       @RequestParam("length") int length,
                                       @RequestParam("search[value]") String searchValue) {
        int pageNumber = start / length;
        Pageable pageable = PageRequest.of(pageNumber, length);

        if (!searchValue.isEmpty()) {
            return proyectosService.findAllPageableByNombreAndIgnoreUpperCase(searchValue, pageable);
        } else {
            return proyectosService.findAllPageable(pageable);
        }
    }

    @GetMapping("/BuscarProyectos")
    public String buscarProyectos(Model model) {
        return "pages/buscarProyectos";
    }
}