package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Implementation of EntityContent interface that returns the ClassName of
 * Spring's GetMapping annotation.
 * 
 * @author Gabriel Reis
 */
public class GetEndPontClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.WebBind.value, SpringClasses.GetMapping.value);
  }

}
