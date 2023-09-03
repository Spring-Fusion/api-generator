package com.appfusion.apigenerator.builder.dynamicType;

import java.time.LocalDateTime;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

public class DynamicLocalDateTime implements AbstractType {
    @Override
    public Class<?> getType() {
      return LocalDateTime.class;
    }
}
