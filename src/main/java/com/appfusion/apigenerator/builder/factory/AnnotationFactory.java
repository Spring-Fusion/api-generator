package com.appfusion.apigenerator.builder.factory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.EntityTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

public class AnnotationFactory {

  public static AnnotationSpec getRestControllerAnnotation(EntityDTO dto) {
    return AnnotationSpec.builder(dto.getTemplate().getRestController()).build();
  }

  public static AnnotationSpec getAutoWiredAnnotation(EntityDTO dto) {
    return AnnotationSpec.builder(dto.getTemplate().getAutoWired()).build();
  }

  public static AnnotationSpec getAnnotationrequestBodyClass(EntityDTO dto) {
    return AnnotationSpec.builder(dto.getTemplate().getRequestBodyClass()).build();
  }

  public static AnnotationSpec getEntityAnnotationSpec(EntityTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getEntityAnnotation()).build();
  }

  public static AnnotationSpec getDataLombokAnntotationSpec(EntityTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getDataAnnotation()).build();
  }

  public static AnnotationSpec getAnnotationPostMapping(EntityDTO dto) {
    return AnnotationSpec.builder(dto.getTemplate().getRequestEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonValue(dto.getJson(), "endPointName")).build();
  }

  public static AnnotationSpec getGeneratedValueAnnotation(EntityTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getGeneratedValueAnnotation())
        .addMember("strategy", "$T.AUTO", entityTemplate.getGenerationTypeAnnotation()).build();

  }

  public static AnnotationSpec getColumnAnnotation(EntityTemplate entityTemplate, String size) {
    return AnnotationSpec.builder(entityTemplate.getColumnAnnotation())
        .addMember("length", size, entityTemplate.getColumnAnnotation()).build();
  }

  public static AnnotationSpec getIdPostIdAnnotation(EntityTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getIdAnnotation()).build();
  }

  public static AnnotationSpec getMethodAnotation(EntityDTO dto, String endPoint, ClassName method) {
    return AnnotationSpec.builder(method)
        .addMember("value", "$S", "/"
            + EntityUtil.getJsonValue(dto.getJson(), "endPointName")
            + endPoint)
        .build();
  }

  public static AnnotationSpec getFieldSizeAnnotation(EntityTemplate entityTemplate, String size) {
    if (size != null) {
      return AnnotationFactory.getColumnAnnotation(entityTemplate, size);
    }
    return null;
  }
}
