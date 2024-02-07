package com.codekion.marketplace.Controller;

import com.codekion.marketplace.Models.DTO.UsuarioHabilidadesCategoriasDTO;
import com.codekion.marketplace.Models.DTO.UsuarioInfoDto;
import com.codekion.marketplace.Models.entity.Usuario;
import com.codekion.marketplace.Service.IService.IUsuarioService;
import com.codekion.marketplace.Utils.UsuarioInfoBuilder;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private static Logger log = org.slf4j.LoggerFactory.getLogger(ColaboradoresController.class);

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/BuscarcolaboradoresPage")
    public String buscarColaboradores(Map<String, Object> model
            , @ModelAttribute("usuario") Usuario sessionUser) {
        List<UsuarioHabilidadesCategoriasDTO> usuariosList = usuarioService.buscarUsuariosYHabilidades();
        //List<UsuarioInfoDto> usuarioInfoList = UsuarioInfoBuilder.buildUsuarioInfoList(usuariosList, sessionUser);
        // Agregar la lista de resultados a los modelos
        //model.put("usuarioInfoList", usuarioInfoList);

        return "pages/buscarColaboradores";
    }

    @GetMapping("/BuscarcolaboradoresPageAjax")
    @ResponseBody
    public Page<UsuarioInfoDto> buscarColaboradoresAjax(@RequestParam("start") int start
            , @RequestParam("length") int length
            , @RequestParam("search[value]") String searchValue
            , @ModelAttribute("usuario") Usuario sessionUser) {
        // Crear un objeto Pageable para la paginación
        int pageNumber = start / length;
        Pageable pageable = PageRequest.of(pageNumber, length);
        // Obtener los usuarios, habilidades y subcategorías paginados
        List<UsuarioHabilidadesCategoriasDTO> usuariosList = usuarioService.buscarUsuariosYHabilidades();
        // Obtener la lista de usuarios según la página
        // Construir la lista de UsuarioInfoDto
        Page<UsuarioInfoDto> lstUsuarioUInfoDTO = UsuarioInfoBuilder.buildUsuarioInfoList(usuariosList, sessionUser, pageable);
        log.info("lstUsuarioUInfoDTO: " + lstUsuarioUInfoDTO.getContent());

        return lstUsuarioUInfoDTO;
    }
}