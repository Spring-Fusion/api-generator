package com.appfusion.apigenerator.builder.jakartaContent.fieldLevel;

import com.appfusion.apigenerator.builder.enums.JakartaPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents a ManyToMany Annotation.
 */
public class ManyToMany implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JakartaPersistence.value, JakartaPackges.ManyToMany.value);
  }

}
