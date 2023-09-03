package com.appfusion.apigenerator.builder.dynamicType;

import java.time.Instant;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

public class DynamicTimeStamp implements AbstractType {

  @Override
  public Class<?> getType() {
    return Instant.class;
  }

}
