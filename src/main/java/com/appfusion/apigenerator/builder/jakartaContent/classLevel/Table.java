package com.appfusion.apigenerator.builder.jakartaContent.classLevel;

import com.appfusion.apigenerator.builder.enums.JakartaPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents a table annotation content for Jakarta Persistence.
 * 
 * @author Gabriel Reis
 */
public class Table implements EntityContent {
  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JakartaPersistence.value, JakartaPackges.Table.value);
  }

}
