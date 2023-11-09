package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.JakartaPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents an implementation of the EntityContent interface that returns the
 * ClassName of a Jakarta Persistence Entity.
 * 
 * @author Gabriel Reis
 */
public class EntityClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JakartaPersistence.value, JakartaPackges.Entity.value);
  }

}
