package com.appfusion.apigenerator.builder.factory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.entityContent.PathVariebleClassName;
import com.squareup.javapoet.ParameterSpec;

public class ParameterFactory {

  public static ParameterSpec getLongParameter() {
    return ParameterSpec
        .builder(Long.class, "id")
        .addAnnotation(new PathVariebleClassName().getContent())
        .build();
  }

  public static ParameterSpec repositoryParameter(EntityDTO dto) {
    return ParameterSpec
        .builder(dto.getTemplate().getRunTimeRepositoryClass(), "repository")
        .build();
  }

  public static ParameterSpec entityParameter(EntityDTO dto) {
    return ParameterSpec
        .builder(dto.getTemplate().getRunTimeEntityClass(), "entity")
        .addAnnotation(AnnotationFactory.getAnnotationrequestBodyClass(dto))
        .build();
  }
}
