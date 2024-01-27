package com.codekion.marketplace.Utils;

import com.codekion.marketplace.Models.entity.Habilidade;
import com.codekion.marketplace.Models.entity.SubCategoria;
import com.codekion.marketplace.Service.IService.IHabilidadesService;
import com.codekion.marketplace.Service.IService.ISubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class ModelPostFormBuilder {

    public void ListHabilitiesAndSubCategoriesBuilder(Map<String, Object> model,IHabilidadesService habilidadesService,ISubCategoriaService subCategoriaService) {
        //creamos las listas con todas las habilidades y subcategorias
        List<Habilidade> lstHabilidades = habilidadesService.findAll();
        List<SubCategoria> lstSubCategoria = subCategoriaService.findAll();
        //Agregamos las listas al modelo
        model.put("habilidades", lstHabilidades);
        model.put("subcategorias", lstSubCategoria);
        model.put("titulo", "Formulario de Habilidades y Preferencias");
    }


}
