package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.factory.JakartaAnnotationFactory;
import com.appfusion.apigenerator.builder.resourceLoader.FolderHandler;
import com.appfusion.apigenerator.builder.service.builder.ModelBuilder;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ModelTemplate;
import com.squareup.javapoet.TypeSpec;

/**
 * This class is responsible for generating a model based on a JSON string.
 * It uses a ModelTemplate to generate a TypeSpec, which is then used to create
 * a Java file.
 * @author Gabriel Reis
 */
public class ModelGenerator {

  public static void generateModel(String json) throws Exception {
    ModelTemplate modelTemplate = ModelTemplate.getModelTemplate();
    TypeSpec spec = ModelBuilder.getModelTypeSpec(json, modelTemplate);
    JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Entities.value, spec,
    EntityUtil.getJsonValue(json, "clientID"));
    FolderHandler.saveJavaFile(fileDTO);
  }

}
