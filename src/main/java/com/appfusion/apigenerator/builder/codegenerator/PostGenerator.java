package com.appfusion.apigenerator.builder.codegenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.util.ControllerUtil;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.service.util.PostUtil;
import com.appfusion.apigenerator.builder.templates.ControllerTemplate;
import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.appfusion.apigenerator.builder.templates.RepositoryTemplate;
import com.squareup.javapoet.TypeSpec;

public class PostGenerator {

  public ResponseEntity<PostEntity> generateDynamicEntity(String json) throws Exception {
    generateEntity(json);
    generateRepository(json);
    generateController(json);
    generateRepository(json);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  public static void generateEntity(String json) throws Exception{
    PostEntityTemplate postTemplate = PostEntityTemplate.getPostTemplate();
    TypeSpec spec = PostUtil.getPostTypeSpec(json, postTemplate);
    ResourceLoader.saveJavaFile(EntityUtil.getJsonPackage(json) + ".entities", spec);
  }
  
  public static void generateRepository(String json) throws Exception {
    RepositoryTemplate repositoryTemplate = RepositoryTemplate.getDefaultTemplate(json);
    TypeSpec spec = RepositoryTemplate.getRepositoryTypeSpec(json, repositoryTemplate);
    ResourceLoader.saveJavaFile(EntityUtil.getJsonPackage(json) + ".repositories", spec);
  }

  public static void generateController(String json) throws Exception {
    ControllerTemplate controllerTemplate = ControllerTemplate.getControllerTemplate(json);
    ResourceLoader.saveJavaFile(EntityUtil.getJsonPackage(json)+".controller", 
        ControllerUtil.buildTypeSpec(json, controllerTemplate));
  }

}
