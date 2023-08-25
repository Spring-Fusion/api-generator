package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

public class DynamicInt implements AbstractType {

  @Override
  public Class<?> getType() {
    return Integer.class;
  }

}
