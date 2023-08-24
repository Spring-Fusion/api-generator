package com.appfusion.apigenerator.builder.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

public class PostGenerator {

  EntityUtil util = new EntityUtil();

  public ResponseEntity<PostEntity> generateDynamicEntity(String json) throws Exception {
    
    PostEntityTemplate postTemplate = new PostEntityTemplate(
        ClassName.get(SpringPackages.JakartaPersistence.value, SpringClasses.Entity.value), 
        ClassName.get(SpringPackages.JakartaPersistence.value, SpringClasses.Id.value), 
        ClassName.get(SpringPackages.Lombok.value, SpringClasses.Data.value), 
        ClassName.get(SpringPackages.JakartaPersistence.value, SpringClasses.GeneratedValue.value),
        ClassName.get(SpringPackages.JakartaPersistence.value, SpringClasses.GenerationType.value),
        getFields(json));

    AnnotationSpec generatedValue = AnnotationSpec.builder(postTemplate.getGeneratedValueAnnotation())
        .addMember("strategy", "$T.AUTO", postTemplate.getGenerationTypeAnnotation()).build();
    AnnotationSpec annotation = AnnotationSpec.builder(postTemplate.getEntityAnnotation()).build();
    AnnotationSpec id = AnnotationSpec.builder(postTemplate.getIdAnnotation()).build();
    AnnotationSpec dataLombok = AnnotationSpec.builder(postTemplate.getDataAnnotation()).build();

    FieldSpec fieldSpec = FieldSpec.builder(Long.class, "id").addModifiers(Modifier.PRIVATE).addAnnotation(id)
        .addAnnotation(generatedValue).build();

    TypeSpec spec = TypeSpec.classBuilder(util.getJsonEntityName(json)).addModifiers(Modifier.PUBLIC)
        .addAnnotation(annotation).addAnnotation(dataLombok).addField(fieldSpec).addFields(getFields(json)).build();

    JavaFile file = JavaFile.builder(util.getJsonPackage(json), spec).build();
    file.writeTo(new File("src/main/java"));
    
    
    
    generateRepository(json);
    generateController(json);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  public List<FieldSpec> getFields(String json) {
    Map<Object, Object> fields = util.getEntityFields(util.getJsonInstance(util.getJsonEntity(json)));
    List<FieldSpec> list = new ArrayList<>();

    for (Object field : fields.keySet()) {
      FieldSpec fieldSpec = FieldSpec.builder(String.class, field.toString()).addModifiers(Modifier.PRIVATE).build();
      list.add(fieldSpec);
    }
    return list;
  }

  public void generateRepository(String json) throws Exception {
    ClassName jpaRepositoryClass = ClassName.get("org.springframework.data.jpa.repository", "JpaRepository");
    ClassName entityType = ClassName.get(util.getJsonPackage(json), util.getJsonEntityName(json));
    TypeSpec repositoryInterface = TypeSpec.interfaceBuilder(util.getJsonEntityName(json) + "Repository")
        .addModifiers(Modifier.PUBLIC).addTypeVariable(TypeVariableName.get("T", entityType))
        .addTypeVariable(TypeVariableName.get("ID"))
        .addSuperinterface(ParameterizedTypeName.get(jpaRepositoryClass, entityType, TypeVariableName.get("ID")))
        .build();

    JavaFile javaFile = JavaFile.builder("com.appfusion.apigenerator.builder.repositories", repositoryInterface)
        .build();

    javaFile.writeTo(new File("src/main/java"));

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
