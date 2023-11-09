package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.ClassName;

/**
 * This class implements the EntityContent interface and provides the
 * implementation for getting the class name of a
 * Spring JPA repository interface.
 * 
 * @author Gabriel Reis
 */
public class JpaRepositoryClassName implements EntityContent {

  @Override
  public ClassName getContent() {
    return ClassName.get(SpringPackages.JpaRepository.value, SpringClasses.JpaRepository.value);
  }

  public ClassName getPackgeContent(String json) {
    return ClassName.get(EntityUtil.getJsonValue(json, "package") + Packages.Entities.value,
        EntityUtil.getJsonValue(json, "entityName"));
  }

}
