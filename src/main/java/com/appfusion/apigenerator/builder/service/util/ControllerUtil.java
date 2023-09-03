package com.appfusion.apigenerator.builder.service.util;

import java.util.Optional;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
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

  public static AnnotationSpec getAnnotationPostMapping(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getRequestEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()))
        .build();
  }
  
  public static AnnotationSpec getAnnotationGetMapping(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) +"GetAll")
        .build();
  }

  public static AnnotationSpec getAnnotationGetMappingById(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) +"GetById/{id}")
        .build();
  }
  
  public static AnnotationSpec getAnnotationDeleteMapping(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getDeleteEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) +"DeleteById/{id}")
        .build();
  }

    public static AnnotationSpec getAnnotationDeleteMappingAll(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getDeleteEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) +"DeleteAll")
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

  public static MethodSpec getSaveEntityMethod(EntityDTO dto) {
    ParameterSpec parameterSpec = 
        ParameterSpec
        .builder(dto.getTemplate().getRunTimeEntityClass(), "entity")
        .addAnnotation(ControllerUtil.getAnnotationrequestBodyClass(dto.getTemplate()))
        .build();

    return MethodSpec.methodBuilder("save" + EntityUtil.getJsonEntityName(dto.getJson()))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(getAnnotationPostMapping(dto))
        .addParameter(parameterSpec)
        .addStatement("repository.save(" + "entity" + ");").build();
  }
  
  public static MethodSpec getMethodGetAll(EntityDTO dto) {
    return MethodSpec
    .methodBuilder("getAll")
    .returns(ParameterizedTypeName.get(ClassName.get(java.util.List.class), 
    dto.getTemplate().getRunTimeEntityClass()))
    .addAnnotation(getAnnotationGetMapping(dto))
    .addModifiers(Modifier.PUBLIC)
    .addStatement("return repository.findAll()")
    .build();  
  }

    public static MethodSpec getMethodGetById(EntityDTO dto) {
    return MethodSpec
    .methodBuilder("getById")
    .addParameter(getLongParameter())
    .returns(ParameterizedTypeName.get(ClassName.get(Optional.class), 
    dto.getTemplate().getRunTimeEntityClass()))
    .addAnnotation(getAnnotationGetMappingById(dto))
    .addModifiers(Modifier.PUBLIC)
    .addStatement("return repository.findById(id)")
    .build();  
  }
  
  public static MethodSpec getDeleteByIdMethod(EntityDTO dto ) {
    return MethodSpec
    .methodBuilder("deleteById")
    .addModifiers(Modifier.PUBLIC)
    .addParameter(getLongParameter())
    .addAnnotation(getAnnotationDeleteMapping(dto))
    .addStatement("repository.deleteById(id)")
    .build();
  }

    public static MethodSpec getDeleteAll(EntityDTO dto ) {
    return MethodSpec
    .methodBuilder("deleteAll")
    .addModifiers(Modifier.PUBLIC)
    .addAnnotation(getAnnotationDeleteMappingAll(dto))
    .addStatement("repository.deleteAll()")
    .build();
  }

  public static ParameterSpec getLongParameter(){
    return ParameterSpec
            .builder(Long.class, "id")
            .addAnnotation(new PathVariebleClassName().getContent())
            .build();
  }
  
  public static TypeSpec buildTypeSpec(EntityDTO dto) {
    return TypeSpec
        .classBuilder(EntityUtil.getJsonEntityName(dto.getJson()) + "Controller")
        .addModifiers(Modifier.PUBLIC)
        .addField(getRepositoryField(dto.getTemplate()))
        .addMethod(getThisControllerMethod(dto.getTemplate()))
        .addMethod(getSaveEntityMethod(dto))
        .addMethod(getMethodGetAll(dto))
        .addMethod(getDeleteByIdMethod(dto))
        .addMethod(getDeleteAll(dto))
        .addMethod(getMethodGetById(dto))
        .addAnnotation(getRestControllerAnnotation(dto.getTemplate()))
        .build();
  }

}
