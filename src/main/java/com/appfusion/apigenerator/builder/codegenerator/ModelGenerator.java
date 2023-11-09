package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.factory.JakartaAnnotationFactory;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.builder.ModelBuilder;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ModelTemplate;
import com.squareup.javapoet.TypeSpec;

public class ModelGenerator {

  public static void generateModel(String json) throws Exception {
    ModelTemplate postTemplate = ModelTemplate.getModelTemplate();
    TypeSpec spec = ModelBuilder.getModelTypeSpec(json, postTemplate);
    JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Entities.value, spec,
    EntityUtil.getJsonValue(json, "clientID"));
    ResourceLoader.saveJavaFile(fileDTO);
  }

}
