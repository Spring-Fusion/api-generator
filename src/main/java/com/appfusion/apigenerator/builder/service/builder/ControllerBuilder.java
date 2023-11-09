package com.appfusion.apigenerator.builder.service.builder;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.factory.AnnotationFactory;
import com.appfusion.apigenerator.builder.factory.FieldFactory;
import com.appfusion.apigenerator.builder.factory.MethodFactory;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.TypeSpec;

/**
 * The ControllerBuilder class is responsible for building a TypeSpec object for
 * a controller class based on the provided EntityDTO.
 * The TypeSpec object represents the controller class and contains methods for
 * handling HTTP requests related to the entity.
 * 
 * @author Gabriel Reis
 */
public class ControllerBuilder {

  /**
   * Builds a TypeSpec object for a controller class based on the provided
   * EntityDTO.
   * 
   * @param dto the EntityDTO object used to build the controller class
   * @return the TypeSpec object representing the controller class
   */
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
