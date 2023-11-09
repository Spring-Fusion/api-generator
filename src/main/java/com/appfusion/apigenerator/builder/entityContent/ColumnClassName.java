package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.JakartaPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * This class implements the EntityContent interface and provides the
 * implementation for the getContent method.
 * The getContent method returns the ClassName object for Jakarta Persistence
 * Column annotation.
 * 
 * @author Gabriel Reis
 */
public class ColumnClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JakartaPersistence.value, JakartaPackges.Column.value);
  }

}
