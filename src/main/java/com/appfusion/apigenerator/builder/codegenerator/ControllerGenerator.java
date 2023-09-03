package com.appfusion.apigenerator.builder.codegenerator;

import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.util.ControllerUtil;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.ControllerTemplate;

public class ControllerGenerator {

  public static void generateController(String json) throws Exception {
    ControllerTemplate controllerTemplate = ControllerTemplate.getControllerTemplate(json);
    ResourceLoader.saveJavaFile(EntityUtil.getJsonPackage(json) + Packages.Controller.value,
    ControllerUtil.buildTypeSpec(json, controllerTemplate));
  }
}
