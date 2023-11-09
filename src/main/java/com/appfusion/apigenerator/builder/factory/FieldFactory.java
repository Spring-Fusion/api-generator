package com.appfusion.apigenerator.builder.factory;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.templates.ModelTemplate;
import com.squareup.javapoet.FieldSpec;

public class FieldFactory {

  public static FieldSpec getRepositoryField(EntityDTO dto) {
    return FieldSpec
      .builder(dto.getTemplate().getRunTimeRepositoryClass(), "repository", Modifier.PRIVATE)
      .addAnnotation(AnnotationFactory.getAutoWiredAnnotation(dto))
      .build();
  }

  public static FieldSpec getIdFieldSpec(ModelTemplate postTemplate) {
    return FieldSpec
      .builder(Long.class, "id")
      .addModifiers(Modifier.PRIVATE).addAnnotation(AnnotationFactory.getIdPostIdAnnotation(postTemplate))
      .addAnnotation(AnnotationFactory.getGeneratedValueAnnotation(postTemplate))
      .build();
  }
}
