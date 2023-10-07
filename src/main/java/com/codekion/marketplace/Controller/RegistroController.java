package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Models.repository.HabilidadesRepository;
import com.codekion.marketplace.Models.repository.UsuarioRepository;
import com.codekion.marketplace.Models.repository.UsuariosSubCategoriasRepository;
import com.codekion.marketplace.Models.service.IService.IHabilidadesService;
import com.codekion.marketplace.Models.service.IService.ISubCategoriaService;
import com.codekion.marketplace.Models.service.IService.IUsuarioService;
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
    private IHabilidadesService habilidadesService;

    @Autowired
    private ISubCategoriaService subCategoriaService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HabilidadesRepository habilidadesRepository;
    @Autowired
    private UsuariosSubCategoriasRepository usuariosSubCategoriasRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("titulo", "Login");
        return "pages/loginForm";
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
        usuarioService.save(usuario);
        //con status.complete se elimina el objeto usuario de la sesion y se cierra la sesion
        status.setComplete();
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
    public String postForm(@RequestParam("habilidades") List<Integer> habilidadesiD, @RequestParam("subCategorias") List<Integer> subCategoriasIds,
                           HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Habilidade> lstHabilidades = habilidadesService.findByIds(habilidadesiD);
        List<SubCategoria> lstSubCategorias = subCategoriaService.findByIds(subCategoriasIds);
        //usuariosSubCategoriasRepository.saveCategoriasUsuarios(usuario, lstSubCategorias);
        //usuarioRepository.save(usuario);
        for (SubCategoria subCategoria : lstSubCategorias) {
            System.out.print(subCategoria.toString());
        }

        for (Habilidade habilidades : lstHabilidades) {
            System.out.print(habilidades.toString());
        }

        return "pages/postForm";
    }

}


