package com.appfusion.apigenerator.builder.dynamicType;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a dynamic type that contains classes for string, boolean, int,
 * double, LocalDateTime, and Instant.
 * 
 * @author Gabriel Reis
 */
@Data
@NoArgsConstructor
public class DynamicType {

  private Class<?> stringType;
  private Class<?> booleanType;
  private Class<?> intType;
  private Class<?> doubleType;
  private Class<?> localDateTime;
  private Class<?> instant;

  public DynamicType(Class<?> stringType,
      Class<?> booleanType,
      Class<?> intType,
      Class<?> doubleType,
      Class<?> localDateTime,
      Class<?> instant) {
    this.stringType = stringType; 
    this.booleanType = booleanType;
    this.intType = intType;
    this.doubleType = doubleType;
    this.localDateTime = localDateTime;
    this.instant = instant;
  }

  /**
   * Returns a map of dynamic types, where each type is represented by a string
   * key and a corresponding class value.
   *
   * @return a map of dynamic types
   */
  public static Map<String, Class<?>> getDynamicType() {
    Map<String, Class<?>> result = new HashMap<>();
    result.put("boolean", new DynamicBoolean().getType());
    result.put("string", new DynamicString().getType());
    result.put("int", new DynamicInt().getType());
    result.put("double", new DynamicDouble().getType());
    result.put("localDateTime", new DynamicLocalDateTime().getType());
    result.put("instant", new DynamicTimeStamp().getType());
    return result;
  }

}
