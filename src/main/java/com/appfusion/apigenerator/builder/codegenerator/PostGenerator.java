package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.service.util.PostBuilder;
import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.squareup.javapoet.TypeSpec;

public class PostGenerator {

  public static void generatePost(String json) throws Exception {
    PostEntityTemplate postTemplate = PostEntityTemplate.getPostTemplate();
    TypeSpec spec = PostBuilder.getPostTypeSpec(json, postTemplate);
    ResourceLoader.saveJavaFile(EntityUtil.getJsonPackage(json) + Packages.Entities.value, spec);
  }

}
