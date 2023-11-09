package com.appfusion.apigenerator.builder.factory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ModelTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

/**
 * This class provides static methods to generate AnnotationSpec objects used in
 * the generation of Java code.
 * The AnnotationSpec objects are used to add annotations to classes, methods,
 * fields, and parameters.
 * 
 * @author Gabriel Reis
 */
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

  public static AnnotationSpec getEntityAnnotationSpec(ModelTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getEntityAnnotation()).build();
  }

  public static AnnotationSpec getDataLombokAnntotationSpec(ModelTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getDataAnnotation()).build();
  }

  public static AnnotationSpec getAnnotationPostMapping(EntityDTO dto) {
    return AnnotationSpec.builder(dto.getTemplate().getRequestEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonValue(dto.getJson(), "endPointName")).build();
  }

  public static AnnotationSpec getGeneratedValueAnnotation(ModelTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getGeneratedValueAnnotation())
        .addMember("strategy", "$T.AUTO", entityTemplate.getGenerationTypeAnnotation()).build();
  }

  public static AnnotationSpec getColumnAnnotation(ModelTemplate entityTemplate, String size) {
    return AnnotationSpec.builder(entityTemplate.getColumnAnnotation())
        .addMember("length", size, entityTemplate.getColumnAnnotation()).build();
  }

  public static AnnotationSpec getIdPostIdAnnotation(ModelTemplate entityTemplate) {
    return AnnotationSpec.builder(entityTemplate.getIdAnnotation()).build();
  }

  public static AnnotationSpec getMethodAnotation(EntityDTO dto, String endPoint, ClassName method) {
    return AnnotationSpec.builder(method)
        .addMember("value", "$S", "/"
            + EntityUtil.getJsonValue(dto.getJson(), "endPointName")
            + endPoint)
        .build();
  }

  public static AnnotationSpec getFieldSizeAnnotation(ModelTemplate entityTemplate, String size) {
    if (size != null) {
      return AnnotationFactory.getColumnAnnotation(entityTemplate, size);
    }
    return null;
  }
}
