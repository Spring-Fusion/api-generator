package com.appfusion.apigenerator.builder.codegenerator;

import java.io.File;

import javax.lang.model.element.Modifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.appfusion.apigenerator.builder.templates.RepositoryTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

public class PostGenerator {

  EntityUtil util = new EntityUtil();

  public ResponseEntity<PostEntity> generateDynamicEntity(String json) throws Exception {
    generateEntity(json);
    generateRepository(json);
    generateController(json);
    generateRepository(json);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  public void generateEntity(String json) throws Exception{
    PostEntityTemplate postTemplate = PostEntityTemplate.getPostTemplate();
    TypeSpec spec = PostEntityTemplate.getPostTypeSpec(json, postTemplate);
    ResourceLoader.saveJavaFile(util.getJsonPackage(json) + ".entities", spec);
  }
  
  public void generateRepository(String json) throws Exception {
    RepositoryTemplate repositoryTemplate = RepositoryTemplate.getDefaultTemplate(json);
    TypeSpec spec = RepositoryTemplate.getRepositoryTypeSpec(json, repositoryTemplate);
    ResourceLoader.saveJavaFile(util.getJsonPackage(json) + ".repositories", spec);
  }

  public void generateController(String json) throws Exception {
    ClassName requestController = ClassName.get("org.springframework.web.bind.annotation", "RestController");
    ClassName autoWired = ClassName.get("org.springframework.beans.factory.annotation", "Autowired");

    AnnotationSpec requestControllerAnnotation = AnnotationSpec.builder(requestController).build();
    AnnotationSpec autoWiredAnnotation = AnnotationSpec.builder(autoWired).build();

    ClassName runTimeRepositoryClass = ClassName.get("com.appfusion.apigenerator.builder.repositories",
        util.getJsonEntityName(json) + "Repository");

    FieldSpec repositoryField = FieldSpec.builder(runTimeRepositoryClass, "repository", Modifier.PRIVATE)
        .addAnnotation(autoWiredAnnotation).build();

    ParameterSpec parameterSpec = ParameterSpec.builder(runTimeRepositoryClass, "repository").build();

    MethodSpec methodSpec = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
        .addStatement("this.repository=repository").addParameter(parameterSpec).build();

    ClassName requestEndPoint = ClassName.get("org.springframework.web.bind.annotation", "PostMapping");
    AnnotationSpec annotationPostMapping = AnnotationSpec.builder(requestEndPoint)
        .addMember("value", "$S", "/" + util.getJsonEndPoint(json)).build();

    ClassName requestBodyClass = ClassName.get("org.springframework.web.bind.annotation", "RequestBody");
    AnnotationSpec annotationrequestBodyClass = AnnotationSpec.builder(requestBodyClass).build();

    ClassName runTimeEntityClass = ClassName.get(util.getJsonPackage(json), util.getJsonEntityName(json));
    ParameterSpec parameterSpec2 = ParameterSpec.builder(runTimeEntityClass, "entity")
        .addAnnotation(annotationrequestBodyClass).build();

    MethodSpec request = MethodSpec.methodBuilder("save" + util.getJsonEntityName(json)).addModifiers(Modifier.PUBLIC)
        .addAnnotation(annotationPostMapping).addParameter(parameterSpec2)
        .addStatement("repository.save(" + "entity" + ");").build();

    TypeSpec spec = TypeSpec.classBuilder(util.getJsonEntityName(json) + "Controller").addModifiers(Modifier.PUBLIC)
        .addField(repositoryField).addMethod(methodSpec).addMethod(request).addAnnotation(requestControllerAnnotation)
        .build();

    JavaFile file = JavaFile.builder("com.appfusion.apigenerator.builder.controller", spec).build();

    file.writeTo(new File("src/main/java"));
  }

}
