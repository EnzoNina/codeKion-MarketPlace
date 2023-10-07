package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.*;
import com.codekion.marketplace.Models.repository.HabilidadesUsuariosRepository;
import com.codekion.marketplace.Models.repository.UsuarioRepository;
import com.codekion.marketplace.Models.repository.UsuariosSubCategoriasRepository;
import com.codekion.marketplace.Models.service.IService.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("titulo", "Login");
        return "pages/login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String user, @RequestParam String pass, Model model) {
        Usuario usuario = usuarioService.findByUserAndPass(user, pass);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "pages/home";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/registrar")
    public String registrar(Map<String, Object> model) {
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Registrar Usuario");
        return "pages/registrar";
    }

    @PostMapping("/registrar")
    public String registrarPost(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Registrar de Usuario");
            return "redirect:/";
        }
        //Podriamos hacer que no se registry en la base datos, ya que ya esta en la sesion, luego de completar todos los
        //formularios posteriores, se registra en la base de datos
        //usuarioService.save(usuario);
        //con status.complete se elimina el objeto usuario de la sesion y se cierra la sesion
        //status.setComplete();
        return "redirect:/postForm";
    }

    @GetMapping("/postForm")
    public String postForm(Map<String, Object> model) {
        List<Habilidade> lstHabilidades = habilidadesService.findAll();
        List<SubCategoria> lstSubCategoria = subCategoriaService.findAll();
        model.put("habilidades", lstHabilidades);
        model.put("subcategorias", lstSubCategoria);
        model.put("titulo", "Formulario de Habilidades y Preferencias");
        return "pages/postForm";
    }

    @PostMapping("/postForm")
    public String postForm(@RequestParam("habilidades") List<Integer> habilidadesiD, @RequestParam("subcategorias") List<Integer> subCategoriasIds,
                           HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        //List<UsuariosHabilidade> lstHabilidades = habilidadesUsuariosService.findAllByIds(usuario, habilidadesiD);
        //List<UsuarioSubCategoria> lstSubCategorias = subCategoriasUsuariosService.findByIDs(usuario, subCategoriasIds);
        List<Habilidade> lstHabilidades = habilidadesService.findByIds(habilidadesiD);
        List<SubCategoria> lstSubCategorias = subCategoriaService.findByIds(subCategoriasIds);

        usuarioService.save(usuario);

        subCategoriasUsuariosService.saveCategoriasUsuarios(usuario, lstSubCategorias);
        habilidadesUsuariosService.saveHabilidadesUsuarios(usuario, lstHabilidades);

        return "pages/postForm";
    }

}


