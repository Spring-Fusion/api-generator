package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents an implementation of EntityContent that returns the ClassName of
 * the Spring Autowired annotation.
 * 
 * @author Gabriel Reis
 */
public class AutoWiredClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.BeansFactory.value, SpringClasses.Autowired.value);
  }

}
