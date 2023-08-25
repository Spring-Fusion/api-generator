package com.appfusion.apigenerator.builder.dynamicType;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

public class DynamicDouble implements AbstractType{

  @Override
  public Class<?> getType() {
    return Double.class;
  }

}
