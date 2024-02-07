package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesCategoriasDTO;
import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import com.codekion.marketplace.Utils.UsuarioInfoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ColaboradoresController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/BuscarcolaboradoresPage")
    public String buscarColaboradores(Map<String, Object> model
            , @ModelAttribute("usuario") Usuario sessionUser) {
        List<UsuarioHabilidadesCategoriasDTO> usuariosList = usuarioService.buscarUsuariosYHabilidades();
        List<UsuarioInfoDto> usuarioInfoList = UsuarioInfoBuilder.buildUsuarioInfoList(usuariosList, sessionUser);
        // Agregar la lista de resultados a los modelos
        model.put("usuarioInfoList", usuarioInfoList);

        return "pages/buscarColaboradores";
    }

    @GetMapping("/BuscarcolaboradoresPageAjax")
    @ResponseBody
    public Page<UsuarioInfoDto> buscarColaboradoresAjax(@ModelAttribute("usuario") Usuario sessionUser
            , @RequestParam(name = "start", defaultValue = "0") int start
            , @RequestParam(name = "length", defaultValue = "5") int length
            , @RequestParam("search[value]") String searchValue) {
        // Crear un objeto Pageable para la paginación
        int pageNumber = start / length;
        Pageable pageable = PageRequest.of(pageNumber, 5);
        // Obtener los usuarios, habilidades y subcategorías paginados
        Page<UsuarioHabilidadesCategoriasDTO> lstUsuario = usuarioService.buscarUsuariosYHabilidadesPageable(pageable);
        // Obtener la lista de usuarios según la página
        List<UsuarioHabilidadesCategoriasDTO> lstUsuarioPage = lstUsuario.getContent();
        // Construir la lista de UsuarioInfoDto
        List<UsuarioInfoDto> lstUsuarioUInfoDTO = UsuarioInfoBuilder.buildUsuarioInfoList(lstUsuarioPage, sessionUser);
        // Construir un objeto Page con la lista de resultados y el objeto Pageable
        return new PageImpl<>(lstUsuarioUInfoDTO, pageable, lstUsuario.getTotalElements());
    }
}