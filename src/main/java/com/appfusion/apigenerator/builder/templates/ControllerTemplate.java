package com.appfusion.apigenerator.builder.templates;

import com.appfusion.apigenerator.builder.entityContent.AutoWiredClassName;
import com.appfusion.apigenerator.builder.entityContent.DeleteEndPointClassName;
import com.appfusion.apigenerator.builder.entityContent.GetEndPontClassName;
import com.appfusion.apigenerator.builder.entityContent.RequestBodyClassName;
import com.appfusion.apigenerator.builder.entityContent.RequestEndPointClassName;
import com.appfusion.apigenerator.builder.entityContent.RestControllerClassName;
import com.appfusion.apigenerator.builder.entityContent.RunTimeEntityClassName;
import com.appfusion.apigenerator.builder.entityContent.RunTimeRepositoryClassName;
import com.appfusion.apigenerator.builder.entityContent.UpdateByIdClassName;
import com.squareup.javapoet.ClassName;

import lombok.Data;

/**
 * This class represents a template for generating a Spring Boot controller
 * class.
 * It contains fields for the necessary class names and a constructor to
 * initialize them.
 * It also provides a static method to create a new instance of the template
 * based on a JSON string.
 *
 * @author Gabriel Reis
 */
@Data
public class ControllerTemplate {

  private ClassName restController;
  private ClassName autoWired;
  private ClassName runTimeRepositoryClass;
  private ClassName requestEndPoint;
  private ClassName getEndPoint;
  private ClassName deleteEndPoint;
  private ClassName requestBodyClass;
  private ClassName runTimeEntityClass;
  private ClassName updateByIdClass;

  public ControllerTemplate(ClassName restController, ClassName autoWired, ClassName runTimeRepositoryClass,
      ClassName requestEndPoint, ClassName getEndPoint, ClassName deleteEdnPoint, ClassName requestBodyClass,
      ClassName runTimeEntityClass,
      ClassName updateByIdClass) {
    this.restController = restController;
    this.autoWired = autoWired;
    this.runTimeRepositoryClass = runTimeRepositoryClass;
    this.requestEndPoint = requestEndPoint;
    this.getEndPoint = getEndPoint;
    this.deleteEndPoint = deleteEdnPoint;
    this.requestBodyClass = requestBodyClass;
    this.runTimeEntityClass = runTimeEntityClass;
    this.updateByIdClass = updateByIdClass;
  }

  public static ControllerTemplate getControllerTemplate(String json) {
    return new ControllerTemplate(
        new RestControllerClassName().getContent(),
        new AutoWiredClassName().getContent(),
        new RunTimeRepositoryClassName(json).getContent(),
        new RequestEndPointClassName().getContent(),
        new GetEndPontClassName().getContent(),
        new DeleteEndPointClassName().getContent(),
        new RequestBodyClassName().getContent(),
        new RunTimeEntityClassName(json).getContent(),
        new UpdateByIdClassName().getContent());
  }
}
