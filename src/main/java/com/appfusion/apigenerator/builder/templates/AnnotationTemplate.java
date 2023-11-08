package com.appfusion.apigenerator.builder.templates;

import java.util.HashMap;
import java.util.Map;

import com.appfusion.apigenerator.builder.jakartaContent.Table;
import com.squareup.javapoet.ClassName;

import lombok.Data;
@Data
public class AnnotationTemplate {

  private ClassName table;

  public AnnotationTemplate(ClassName table) {
    this.table = table;
  }
  public static Map<String , ClassName> getAnnotations(){
    Map<String, ClassName> result = new HashMap<>();
    result.put("table", new Table().getContent());
    return result;
  }

}
