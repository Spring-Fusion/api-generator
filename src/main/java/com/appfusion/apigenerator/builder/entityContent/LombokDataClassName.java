package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.LombokPackges;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

public class LombokDataClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.Lombok.value, LombokPackges.Data.value);
  }

}
