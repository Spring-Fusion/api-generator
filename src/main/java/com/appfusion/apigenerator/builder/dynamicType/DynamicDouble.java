package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * Represents a dynamic type that holds a double value.
 * Implements the AbstractType interface.
 * 
 * @author Gabriel Reis
 * @see AbstractType
 */
public class DynamicDouble implements AbstractType {

  @Override
  public Class<?> getType() {
    return Double.class;
  }

}
