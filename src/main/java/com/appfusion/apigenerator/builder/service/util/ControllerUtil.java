package com.appfusion.apigenerator.builder.service.util;

import java.util.Optional;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.entityContent.PathVariebleClassName;
import com.appfusion.apigenerator.builder.templates.ControllerTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

public class ControllerUtil {

  public static AnnotationSpec getRestControllerAnnotation(ControllerTemplate template) {
    return AnnotationSpec.builder(template.getRestController()).build();
  }

  public static AnnotationSpec getAutoWiredAnnotation(ControllerTemplate template) {
    return AnnotationSpec.builder(template.getAutoWired()).build();
  }

  public static AnnotationSpec getAnnotationPostMapping(String json, ControllerTemplate template) {
    return AnnotationSpec
        .builder(template.getRequestEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json))
        .build();
  }
  
  public static AnnotationSpec getAnnotationGetMapping(String json, ControllerTemplate template) {
    return AnnotationSpec
        .builder(template.getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json) +"GetAll")
        .build();
  }

  public static AnnotationSpec getAnnotationGetMappingById(String json, ControllerTemplate template) {
    return AnnotationSpec
        .builder(template.getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json) +"GetById/{id}")
        .build();
  }
  
  public static AnnotationSpec getAnnotationDeleteMapping(String json, ControllerTemplate template) {
    return AnnotationSpec
        .builder(template.getDeleteEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json) +"DeleteById/{id}")
        .build();
  }

    public static AnnotationSpec getAnnotationDeleteMappingAll(String json, ControllerTemplate template) {
    return AnnotationSpec
        .builder(template.getDeleteEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json) +"DeleteAll")
        .build();
  }

  public static AnnotationSpec getAnnotationrequestBodyClass(ControllerTemplate template) {
    return AnnotationSpec.builder(template.getRequestBodyClass()).build();
  }
  
  public static FieldSpec getRepositoryField(ControllerTemplate controllerTemplate) {
    return FieldSpec
        .builder(controllerTemplate.getRunTimeRepositoryClass(),"repository",Modifier.PRIVATE)
        .addAnnotation(ControllerUtil.getAutoWiredAnnotation(controllerTemplate))
        .build();
  }
  
  public static MethodSpec getThisControllerMethod(ControllerTemplate controllerTemplate) {
    ParameterSpec parameterSpec = 
        ParameterSpec
        .builder(controllerTemplate.getRunTimeRepositoryClass(), "repository")
        .build();
    return MethodSpec
        .constructorBuilder()
        .addModifiers(Modifier.PUBLIC)
        .addStatement("this.repository=repository")
        .addParameter(parameterSpec).build();
  }

  public static MethodSpec getSaveEntityMethod(String json, ControllerTemplate controllerTemplate) {
    ParameterSpec parameterSpec = 
        ParameterSpec
        .builder(controllerTemplate.getRunTimeEntityClass(), "entity")
        .addAnnotation(ControllerUtil.getAnnotationrequestBodyClass(controllerTemplate))
        .build();

    return MethodSpec.methodBuilder("save" + EntityUtil.getJsonEntityName(json))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(getAnnotationPostMapping(json, controllerTemplate))
        .addParameter(parameterSpec)
        .addStatement("repository.save(" + "entity" + ");").build();
  }
  
  public static MethodSpec getMethodGetAll(String json, ControllerTemplate controllerTemplate) {
    return MethodSpec
    .methodBuilder("getAll")
    .returns(ParameterizedTypeName.get(ClassName.get(java.util.List.class), controllerTemplate.getRunTimeEntityClass()))
    .addAnnotation(getAnnotationGetMapping(json, controllerTemplate))
    .addModifiers(Modifier.PUBLIC)
    .addStatement("return repository.findAll()")
    .build();  
  }

    public static MethodSpec getMethodGetById(String json, ControllerTemplate controllerTemplate) {
    return MethodSpec
    .methodBuilder("getById")
    .addParameter(getLongParameter())
    .returns(ParameterizedTypeName.get(ClassName.get(Optional.class), controllerTemplate.getRunTimeEntityClass()))
    .addAnnotation(getAnnotationGetMappingById(json, controllerTemplate))
    .addModifiers(Modifier.PUBLIC)
    .addStatement("return repository.findById(id)")
    .build();  
  }
  
  public static MethodSpec getDeleteByIdMethod(String json, ControllerTemplate controllerTemplate ) {
    return MethodSpec
    .methodBuilder("deleteById")
    .addModifiers(Modifier.PUBLIC)
    .addParameter(getLongParameter())
    .addAnnotation(getAnnotationDeleteMapping(json, controllerTemplate))
    .addStatement("repository.deleteById(id)")
    .build();
  }

    public static MethodSpec getDeleteAll(String json, ControllerTemplate controllerTemplate ) {
    return MethodSpec
    .methodBuilder("deleteAll")
    .addModifiers(Modifier.PUBLIC)
    .addAnnotation(getAnnotationDeleteMappingAll(json, controllerTemplate))
    .addStatement("repository.deleteAll()")
    .build();
  }

  public static ParameterSpec getLongParameter(){
    return ParameterSpec
            .builder(Long.class, "id")
            .addAnnotation(new PathVariebleClassName().getContent())
            .build();
  }
  
  public static TypeSpec buildTypeSpec(String json, ControllerTemplate controllerTemplate) {
    return TypeSpec
        .classBuilder(EntityUtil.getJsonEntityName(json) + "Controller")
        .addModifiers(Modifier.PUBLIC)
        .addField(getRepositoryField(controllerTemplate))
        .addMethod(getThisControllerMethod(controllerTemplate))
        .addMethod(getSaveEntityMethod(json, controllerTemplate))
        .addMethod(getMethodGetAll(json, controllerTemplate))
        .addMethod(getDeleteByIdMethod(json, controllerTemplate))
        .addMethod(getDeleteAll(json, controllerTemplate))
        .addMethod(getMethodGetById(json, controllerTemplate))
        .addAnnotation(getRestControllerAnnotation(controllerTemplate))
        .build();
  }

}
