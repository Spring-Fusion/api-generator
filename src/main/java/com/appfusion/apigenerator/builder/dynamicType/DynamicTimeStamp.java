package com.appfusion.apigenerator.builder.dynamicType;

import java.time.Instant;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * This class represents a dynamic type for a timestamp value.
 * It implements the AbstractType interface and returns the Instant class as its
 * type.
 * 
 * @author Gabriel Reis
 */
public class DynamicTimeStamp implements AbstractType {

  @Override
  public Class<?> getType() {
    return Instant.class;
  }

}
