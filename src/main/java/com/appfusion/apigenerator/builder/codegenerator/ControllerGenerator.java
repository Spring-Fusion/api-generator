package com.appfusion.apigenerator.builder.codegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.FolderHandler;
import com.appfusion.apigenerator.builder.service.builder.ControllerBuilder;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ControllerTemplate;

/**
 * This class is responsible for generating a controller based on a JSON input.
 * 
 * © Spring Fusion 2023
 * 
 * @author Gabriel Reis
 */
public class ControllerGenerator {

  private static Logger LOG = LoggerFactory.getLogger(ControllerGenerator.class);

  /**
   * Generates a controller based on the provided JSON input.
   * 
   * @param json The JSON input used to generate the controller.
   */
  public static void generateController(String json) {
    try {
      ControllerTemplate controllerTemplate = ControllerTemplate.getControllerTemplate(json);
      EntityDTO dto = new EntityDTO(json, controllerTemplate);
      JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Controller.value,
      ControllerBuilder.buildTypeSpec(dto), EntityUtil.getJsonValue(json, "clientID"));
      FolderHandler.saveJavaFile(fileDTO);
      LOG.info("Controller generated successfully");
    } catch (Exception e) {
      LOG.error("Error generating controller: " + e.getMessage());
    }
  }
}
