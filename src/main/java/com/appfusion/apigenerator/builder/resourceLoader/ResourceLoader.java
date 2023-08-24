package com.appfusion.apigenerator.builder.resourceLoader;

import java.io.File;

import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

public class ResourceLoader {

  static EntityUtil util = new EntityUtil();
  
  public static void saveJavaFile(String jsonPackage, TypeSpec spec) throws Exception {
    JavaFile file = JavaFile.builder(jsonPackage, spec).build();
    file.writeTo(new File("src/main/java"));
  }
  
}
