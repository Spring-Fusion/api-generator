package com.appfusion.apigenerator.builder.templates;

import java.util.HashMap;
import java.util.Map;

import com.appfusion.apigenerator.builder.jakartaContent.Table;
import com.squareup.javapoet.ClassName;

import lombok.Data;

/**
 * This class represents a template for generating annotations.
 * 
 * @author Gabriel Reis
 */
@Data
public class AnnotationTemplate {

  private ClassName table;

  public AnnotationTemplate(ClassName table) {
    this.table = table;
  }

  /**
   * Returns a map of annotations.
   * 
   * @return a map of annotations
   */
  public static Map<String, ClassName> getAnnotations() {
    Map<String, ClassName> result = new HashMap<>();
    result.put("table", new Table().getContent());
    return result;
  }

}
