package com.appfusion.apigenerator.builder.service.util;

import javax.lang.model.element.Modifier;

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

  public static AnnotationSpec getAnnotationPostMapping(String json, ControllerTemplate template) {
    return AnnotationSpec.builder(template.getRequestEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json)).build();
  }
  
  public static AnnotationSpec getAnnotationGetMapping(String json, ControllerTemplate template) {
    return AnnotationSpec.builder(template.getGetEndPoint())
        .addMember("value", "$S", "/" + EntityUtil.getJsonEndPoint(json) +"getAll").build();
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

  public static MethodSpec getSaveEntityMethod(String json, ControllerTemplate controllerTemplate) {
    ParameterSpec parameterSpec = 
        ParameterSpec
        .builder(controllerTemplate.getRunTimeEntityClass(), "entity")
        .addAnnotation(ControllerUtil.getAnnotationrequestBodyClass(controllerTemplate))
        .build();

    return MethodSpec.methodBuilder("save" + EntityUtil.getJsonEntityName(json))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(getAnnotationPostMapping(json, controllerTemplate))
        .addParameter(parameterSpec)
        .addStatement("repository.save(" + "entity" + ");").build();
  }
  
  
  public static MethodSpec getMethodGetAll(String json, ControllerTemplate controllerTemplate) {
    return MethodSpec
    .methodBuilder("getAll")
    .returns(ParameterizedTypeName.get(ClassName.get(java.util.List.class), controllerTemplate.getRunTimeEntityClass()))
    .addAnnotation(getAnnotationGetMapping(json, controllerTemplate))
    .addModifiers(Modifier.PUBLIC)
    .addStatement("return repository.findAll()")
    .build();  
  }
  
  public static TypeSpec buildTypeSpec(String json, ControllerTemplate controllerTemplate) {
    return TypeSpec
        .classBuilder(EntityUtil.getJsonEntityName(json) + "Controller")
        .addModifiers(Modifier.PUBLIC)
        .addField(getRepositoryField(controllerTemplate))
        .addMethod(getThisControllerMethod(controllerTemplate))
        .addMethod(getSaveEntityMethod(json, controllerTemplate))
        .addMethod(getMethodGetAll(json, controllerTemplate))
        .addAnnotation(getRestControllerAnnotation(controllerTemplate))
        .build();
  }

}
