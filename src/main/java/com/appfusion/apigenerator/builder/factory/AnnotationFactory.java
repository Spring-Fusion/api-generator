package com.appfusion.apigenerator.builder.factory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.squareup.javapoet.AnnotationSpec;

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

  public static AnnotationSpec getEntityAnnotationSpec(PostEntityTemplate postTemplate) {
    return AnnotationSpec.builder(postTemplate.getEntityAnnotation()).build();
  }

  public static AnnotationSpec getDataLombokAnntotationSpec(PostEntityTemplate postTemplate) {
    return AnnotationSpec.builder(postTemplate.getDataAnnotation()).build();
  }

  public static AnnotationSpec getAnnotationPostMapping(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getRequestEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()))
        .build();
  }

  public static AnnotationSpec getGeneratedValueAnnotation(PostEntityTemplate postTemplate){
    return  AnnotationSpec
    .builder(postTemplate.getGeneratedValueAnnotation())
    .addMember("strategy", "$T.AUTO", postTemplate.getGenerationTypeAnnotation())
    .build();

  }

  public static AnnotationSpec getIdPostIdAnnotation(PostEntityTemplate postTemplate){
    return AnnotationSpec
    .builder(postTemplate.getIdAnnotation())
    .build();
  }

  public static AnnotationSpec getAnnotationGetMapping(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) + "GetAll")
        .build();
  }

  public static AnnotationSpec getAnnotationGetMappingById(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) + "GetById/{id}")
        .build();
  }

  public static AnnotationSpec getAnnotationDeleteMapping(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getDeleteEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) + "DeleteById/{id}")
        .build();
  }

  public static AnnotationSpec getAnnotationDeleteMappingAll(EntityDTO dto) {
    return AnnotationSpec
        .builder(dto.getTemplate().getDeleteEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(dto.getJson()) + "DeleteAll")
        .build();
  }
}
