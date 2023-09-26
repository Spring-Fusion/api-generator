package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.builder.EntityBuilder;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.EntityTemplate;
import com.squareup.javapoet.TypeSpec;

public class PostGenerator {

  public static void generatePost(String json) throws Exception {
    EntityTemplate postTemplate = EntityTemplate.getPostTemplate();
    TypeSpec spec = EntityBuilder.getPostTypeSpec(json, postTemplate);
    JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Entities.value, spec,
    EntityUtil.getJsonValue(json, "clientID"));
    ResourceLoader.saveJavaFile(fileDTO);
  }

}
