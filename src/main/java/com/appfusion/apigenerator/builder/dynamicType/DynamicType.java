package com.appfusion.apigenerator.builder.dynamicType;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DynamicType {

  private Class<?> stringType;
  private Class<?> booleanType;
  private Class<?> intType;
  private Class<?> doubleType;

  public DynamicType(Class<?> stringType, Class<?> booleanType, Class<?> intType, Class<?> doubleType) {
    this.stringType = stringType;
    this.booleanType = booleanType;
    this.intType = intType;
    this.doubleType = doubleType;
  }

  public static Map<String, Class<?>> getDynamicType() {
    Map<String, Class<?>> result = new HashMap<>();
    result.put("boolean", new DynamicBoolean().getType());
    result.put("string", new DynamicString().getType());
    result.put("int", new DynamicInt().getType());
    result.put("double", new DynamicDouble().getType());
    return result;
  }

}
