package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Service.IService.*;
import com.codekion.marketplace.Utils.ModelPostFormBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@SessionAttributes("usuario")
public class RegistroController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IHabilidadesUsuariosService habilidadesUsuariosService;

    @Autowired
    private IHabilidadesService habilidadesService;

    @Autowired
    private ISubCategoriaService subCategoriaService;

    @Autowired
    private ISub_Categorias_UsuariosService subCategoriasUsuariosService;

    ModelPostFormBuilder modelPostFormBuilder = new ModelPostFormBuilder();

    @RequestMapping(value = "/registrar")
    public String registrar(Map<String, Object> model) {
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Registrar Usuario");
        return "pages/registrar";
    }

    @PostMapping("/registrar")
    public String registrarPost(@Valid Usuario usuario, BindingResult result, Map<String, Object> model, HttpSession session) {
        if (result.hasErrors()) {
            model.put("error", "Error al registrar");
            return "redirect:/";
        }
        try {
            //Obtenemos el objeto usuario a la session
            session.setAttribute("usuarioRegister", usuario);
            //Agregamos las listas al modelo
            modelPostFormBuilder.ListHabilitiesAndSubCategoriesBuilder(model, habilidadesService, subCategoriaService);
            return "pages/postForm";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/registrarPostForm")
    public String postForm(@RequestParam("habilidades") List<Integer> habilidadesiD, @RequestParam("subcategorias") List<Integer> subCategoriasIds,
                           HttpSession session) {
        //Obtenemos el objeto usuario a la session
        Usuario usuario = (Usuario) session.getAttribute("usuarioRegister");
        //Obtenemos las listas de habilidades y subcategorias
        List<Habilidade> lstHabilidades = habilidadesService.findByIds(habilidadesiD);
        List<SubCategoria> lstSubCategorias = subCategoriaService.findByIds(subCategoriasIds);
        //Guardamos el usuario
        usuarioService.save(usuario);
        //Guardamos las habilidades y subcategorias
        subCategoriasUsuariosService.saveCategoriasUsuarios(usuario, lstSubCategorias);
        habilidadesUsuariosService.saveHabilidadesUsuarios(usuario, lstHabilidades);

        return "redirect:/home";
    }

}


