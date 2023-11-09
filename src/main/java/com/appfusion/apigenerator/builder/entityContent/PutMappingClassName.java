package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * This class represents the entity content for the @PutMapping annotation's
 * class name.
 * 
 * @author Gabriel Reis
 */
public class PutMappingClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.WebBind.value, SpringClasses.PutMapping.value);
  }

}
