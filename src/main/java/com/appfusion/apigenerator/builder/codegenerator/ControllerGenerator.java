package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.builder.ControllerBuilder;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ControllerTemplate;

public class ControllerGenerator {

  public static void generateController(String json) throws Exception {
    ControllerTemplate controllerTemplate = ControllerTemplate.getControllerTemplate(json);
    EntityDTO dto = new EntityDTO(json, controllerTemplate);
    JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonPackage(json) + Packages.Controller.value,
    ControllerBuilder.buildTypeSpec(dto), EntityUtil.getClientIDFromJson(json));
    ResourceLoader.saveJavaFile(fileDTO);
  }
}
