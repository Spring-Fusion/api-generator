package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

public class DynamicBoolean implements AbstractType {

  @Override
  public Class<?> getType() {
    return Boolean.class;
  }

}
