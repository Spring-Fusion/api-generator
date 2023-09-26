package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.ClassName;

import lombok.Data;

@Data
public class RunTimeRepositoryClassName implements EntityContent {
  private String json;

  public RunTimeRepositoryClassName(String json) {
    this.json = json;
  }

  @Override
  public ClassName getContent() {
    return ClassName.get(EntityUtil.getJsonValue(this.json, "package") + Packages.Repositories.value,
        EntityUtil.getJsonValue(json, "entityName") + "Repository");
  }

}
