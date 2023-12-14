package com.appfusion.apigenerator.builder.jakartaContent.fieldLevel;

import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * Represents a one-to-one Annotation.
 * 
 * @author Gabriel Reis
 */
public class OneToOne implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get("javax.persistence", "OneToOne");
  }

}
