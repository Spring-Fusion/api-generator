package com.appfusion.apigenerator.builder.service.builder;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.factory.AnnotationFactory;
import com.appfusion.apigenerator.builder.factory.FieldFactory;
import com.appfusion.apigenerator.builder.factory.MethodFactory;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.TypeSpec;

public class ControllerBuilder {

  public static TypeSpec buildTypeSpec(EntityDTO dto) {
    return TypeSpec
        .classBuilder(EntityUtil.getJsonValue(dto.getJson(), "entityName") + "Controller")
        .addModifiers(Modifier.PUBLIC)
        .addField(FieldFactory.getRepositoryField(dto))
        .addMethod(MethodFactory.getThisControllerMethod(dto))
        .addMethod(MethodFactory.getSaveEntityMethod(dto))
        .addMethod(MethodFactory.getMethodGetAll(dto))
        .addMethod(MethodFactory.getDeleteByIdMethod(dto))
        .addMethod(MethodFactory.getDeleteAll(dto))
        .addMethod(MethodFactory.getMethodGetById(dto))
        .addMethod(MethodFactory.updateById(dto))
        .addAnnotation(AnnotationFactory.getRestControllerAnnotation(dto))
        .build();
  }

}
