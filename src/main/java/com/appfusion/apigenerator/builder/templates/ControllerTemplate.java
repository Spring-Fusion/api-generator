package com.appfusion.apigenerator.builder.templates;

import com.appfusion.apigenerator.builder.entityContent.AutoWiredClassName;
import com.appfusion.apigenerator.builder.entityContent.GetEndPontClassName;
import com.appfusion.apigenerator.builder.entityContent.RequestBodyClassName;
import com.appfusion.apigenerator.builder.entityContent.RequestEndPointClassName;
import com.appfusion.apigenerator.builder.entityContent.RestControllerClassName;
import com.appfusion.apigenerator.builder.entityContent.RunTimeEntityClassName;
import com.appfusion.apigenerator.builder.entityContent.RunTimeRepositoryClassName;
import com.squareup.javapoet.ClassName;

import lombok.Data;

@Data
public class ControllerTemplate {

  private ClassName restController;
  private ClassName autoWired;
  private ClassName runTimeRepositoryClass;
  private ClassName requestEndPoint;
  private ClassName getEndPoint;
  private ClassName requestBodyClass;
  private ClassName runTimeEntityClass;

  public ControllerTemplate(ClassName restController, ClassName autoWired, ClassName runTimeRepositoryClass,
      ClassName requestEndPoint, ClassName getEndPoint, ClassName requestBodyClass, ClassName runTimeEntityClass) {
    this.restController = restController;
    this.autoWired = autoWired;
    this.runTimeRepositoryClass = runTimeRepositoryClass;
    this.requestEndPoint = requestEndPoint;
    this.getEndPoint = getEndPoint;
    this.requestBodyClass = requestBodyClass;
    this.runTimeEntityClass = runTimeEntityClass;
  }

  
  public static ControllerTemplate getControllerTemplate(String json) {
    return new ControllerTemplate(
        new RestControllerClassName().getContent(),
        new AutoWiredClassName().getContent(),
        new RunTimeRepositoryClassName(json).getContent(),
        new RequestEndPointClassName().getContent(),
        new GetEndPontClassName().getContent(),
        new RequestBodyClassName().getContent(),
        new RunTimeEntityClassName(json).getContent()
        );
  }





}
