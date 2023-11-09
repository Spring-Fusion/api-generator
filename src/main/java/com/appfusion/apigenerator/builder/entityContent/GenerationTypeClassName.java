package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.JakartaPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * This class implements the EntityContent interface and provides the content
 * for the GenerationType class name.
 * 
 * @author Gabriel Reis
 */
public class GenerationTypeClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JakartaPersistence.value, JakartaPackges.GenerationType.value);
  }

}
