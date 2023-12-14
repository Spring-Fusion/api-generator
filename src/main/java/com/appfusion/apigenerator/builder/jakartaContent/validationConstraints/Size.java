package com.appfusion.apigenerator.builder.jakartaContent.validationConstraints;

import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

public class Size implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get("jakarta.validation.constraints", "Size");
  }
  
}
