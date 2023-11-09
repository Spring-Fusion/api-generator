package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * This class represents a dynamic string type.
 * 
 * @author Gabriel Reis
 */
public class DynamicString implements AbstractType {

  @Override
  public Class<?> getType() {
    return String.class;
  }

}
