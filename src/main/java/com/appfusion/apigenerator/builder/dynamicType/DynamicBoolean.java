package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * This class represents a dynamic boolean type.
 * 
 * @see AbstractType
 * @author Gabriel Reis
 */
public class DynamicBoolean implements AbstractType {

  @Override
  public Class<?> getType() {
    return Boolean.class;
  }

}
