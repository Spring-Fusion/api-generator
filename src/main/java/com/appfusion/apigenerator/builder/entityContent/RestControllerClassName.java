package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * This class represents the content of a Spring Rest Controller class name.
 * 
 * @author Gabriel Reis
 */
public class RestControllerClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.WebBind.value, SpringClasses.RestController.value);
  }

}
