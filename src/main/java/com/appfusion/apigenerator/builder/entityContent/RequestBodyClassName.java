package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

public class RequestBodyClassName implements EntityContent {
  
  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.WebBind.value, SpringClasses.RequestBody.value);
  }

}
