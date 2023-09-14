package com.appfusion.apigenerator.builder.service.builder;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.factory.AnnotationFactory;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.EntityTemplate;
import com.squareup.javapoet.TypeSpec;

public class EntityBuilder {

  public static TypeSpec getPostTypeSpec(String json, EntityTemplate entityTemplate) {
    return TypeSpec
        .classBuilder(EntityUtil.getJsonEntityName(json))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(AnnotationFactory.getEntityAnnotationSpec(entityTemplate))
        .addAnnotation(AnnotationFactory.getDataLombokAnntotationSpec(entityTemplate))
        .addFields(EntityUtil.getFields(json, entityTemplate)).build();
  }
}
