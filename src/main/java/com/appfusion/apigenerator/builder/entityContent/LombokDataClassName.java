package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.LombokPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents an implementation of EntityContent that returns the ClassName of a
 * Lombok Data class.
 * 
 * @author Gabriel Reis
 */
public class LombokDataClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.Lombok.value, LombokPackges.Data.value);
  }

}
