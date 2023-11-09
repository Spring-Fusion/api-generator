package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.ClassName;
import lombok.Data;

/**
 * Represents a runtime entity class name.
 * This class implements the EntityContent interface.
 * It contains a JSON string and provides a method to get the class name as a
 * ClassName object.
 * 
 * @author Gabriel Reis
 */
@Data
public class RunTimeEntityClassName implements EntityContent {

  private String json;

  public RunTimeEntityClassName(String json) {
    this.json = json;
  }

  @Override
  public ClassName getContent() {
    return ClassName.get(EntityUtil.getJsonValue(this.json, "package") + Packages.Entities.value,
        EntityUtil.getJsonValue(json, "entityName"));
  }

}
