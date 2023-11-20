package com.appfusion.apigenerator.builder.codegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.FolderHandler;
import com.appfusion.apigenerator.builder.service.builder.ModelBuilder;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ModelTemplate;
import com.squareup.javapoet.TypeSpec;

/**
 * This class is responsible for generating a model based on a JSON string.
 * It uses a ModelTemplate to generate a TypeSpec, which is then used to create
 * a Java file.
 * 
 * © Spring Fusion 2023
 * 
 * @author Gabriel Reis
 */
public class ModelGenerator {

  private static Logger LOG = LoggerFactory.getLogger(ModelGenerator.class);

  /**
   * Generates a model based on the provided JSON string.
   * 
   * @param json the JSON string representing the model data
   */
  public static void generateModel(String json) {

    try {
      ModelTemplate modelTemplate = ModelTemplate.getModelTemplate();
      TypeSpec spec = ModelBuilder.getModelTypeSpec(json, modelTemplate);
      JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Entities.value, spec,
      EntityUtil.getJsonValue(json, "clientID"));
      FolderHandler.saveJavaFile(fileDTO);
      LOG.info("Model generated successfully");
    } catch (Exception e) {
      LOG.error("Error generating model: " + e.getMessage());
    }

  }

}
