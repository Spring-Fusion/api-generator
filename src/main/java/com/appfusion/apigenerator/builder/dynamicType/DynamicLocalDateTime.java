package com.appfusion.apigenerator.builder.dynamicType;

import java.time.LocalDateTime;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * Represents a dynamic type for LocalDateTime.
 * 
 * @author Gabriel Reis
 */
public class DynamicLocalDateTime implements AbstractType {

  @Override
  public Class<?> getType() {
    return LocalDateTime.class;
  }

}
