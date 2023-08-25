package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

public class DynamicString implements AbstractType {

  @Override
  public Class<?> getType() {
    return String.class;
  }

}
