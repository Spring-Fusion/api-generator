package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * Represents a dynamic integer type.
 * 
 * @author Gabriel Reis
 */
public class DynamicInt implements AbstractType {

  @Override
  public Class<?> getType() {
    return Integer.class;
  }

}
