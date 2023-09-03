package com.appfusion.apigenerator.builder.factory;

import java.util.Optional;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ControllerTemplate;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;

public class MethodFactory {

  public static MethodSpec getThisControllerMethod(EntityDTO dto) {
    return MethodSpec
        .constructorBuilder()
        .addModifiers(Modifier.PUBLIC)
        .addStatement("this.repository=repository")
        .addParameter(ParameterFactory.repositoryParameter(dto)).build();
  }

  public static MethodSpec getSaveEntityMethod(EntityDTO dto) {
    return MethodSpec.methodBuilder("save" + EntityUtil.getJsonEntityName(dto.getJson()))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(AnnotationFactory.getAnnotationPostMapping(dto))
        .addParameter(ParameterFactory.entityParameter(dto))
        .addStatement("repository.save(" + "entity" + ");").build();
  }

  public static MethodSpec getMethodGetAll(EntityDTO dto) {
    return MethodSpec
        .methodBuilder("getAll")
        .returns(ParameterizedTypeName.get(ClassName.get(java.util.List.class),
        dto.getTemplate()
        .getRunTimeEntityClass()))
        .addAnnotation(AnnotationFactory.getAnnotationGetMapping(dto))
        .addModifiers(Modifier.PUBLIC)
        .addStatement("return repository.findAll()")
        .build();
  }

  public static MethodSpec getMethodGetById(EntityDTO dto) {
    return MethodSpec
        .methodBuilder("getById")
        .addParameter(ParameterFactory.getLongParameter())
        .returns(ParameterizedTypeName.get(ClassName.get(Optional.class),
        dto.getTemplate()
        .getRunTimeEntityClass()))
        .addAnnotation(AnnotationFactory.getAnnotationGetMappingById(dto))
        .addModifiers(Modifier.PUBLIC)
        .addStatement("return repository.findById(id)")
        .build();
  }

  public static MethodSpec getDeleteByIdMethod(EntityDTO dto) {
    return MethodSpec
        .methodBuilder("deleteById")
        .addModifiers(Modifier.PUBLIC)
        .addParameter(ParameterFactory.getLongParameter())
        .addAnnotation(AnnotationFactory.getAnnotationDeleteMapping(dto))
        .addStatement("repository.deleteById(id)")
        .build();
  }

  public static MethodSpec getDeleteAll(EntityDTO dto) {
    return MethodSpec
        .methodBuilder("deleteAll")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(AnnotationFactory.getAnnotationDeleteMappingAll(dto))
        .addStatement("repository.deleteAll()")
        .build();
  }
}
