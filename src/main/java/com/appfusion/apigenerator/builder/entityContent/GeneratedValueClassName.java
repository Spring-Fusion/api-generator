package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.JakartaPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents a class that implements the EntityContent interface and returns
 * the ClassName of the Jakarta Persistence GeneratedValue annotation.
 * 
 * @author Gabriel Reis
 */
public class GeneratedValueClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JakartaPersistence.value, JakartaPackges.GeneratedValue.value);
  }

}
