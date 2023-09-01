package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.RepositoryTemplate;
import com.squareup.javapoet.TypeSpec;

public class RepositoryGenerator {
  
  public static void generateRepository(String json) throws Exception {
    RepositoryTemplate repositoryTemplate = RepositoryTemplate.getDefaultTemplate(json);
    TypeSpec spec = RepositoryTemplate.getRepositoryTypeSpec(json, repositoryTemplate);
    ResourceLoader.saveJavaFile(EntityUtil.getJsonPackage(json) + Packages.Repositories.value, spec);
  }
  
}