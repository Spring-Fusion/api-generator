package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.ClassName;

public class JpaRepositoryClassName implements EntityContent {

  EntityUtil util = new EntityUtil();

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JpaRepository.value, SpringClasses.JpaRepository.value);
  }

  public ClassName getPackgeContent(String json) {
    return ClassName.get(util.getJsonPackage(json)+".entities", util.getJsonEntityName(json));
  }

}