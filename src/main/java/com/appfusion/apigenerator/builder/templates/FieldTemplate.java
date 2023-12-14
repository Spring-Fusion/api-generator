package com.appfusion.apigenerator.builder.templates;

import java.util.HashMap;
import java.util.Map;

import com.appfusion.apigenerator.builder.jakartaContent.fieldLevel.ManyToMany;
import com.appfusion.apigenerator.builder.jakartaContent.fieldLevel.ManyToOne;
import com.appfusion.apigenerator.builder.jakartaContent.fieldLevel.OneToMany;
import com.appfusion.apigenerator.builder.jakartaContent.fieldLevel.OneToOne;
import com.appfusion.apigenerator.builder.jakartaContent.validationConstraints.Size;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;

import lombok.Data;

/**
 * Represents a template for a field in a class.
 * 
 * @author Gabriel Reis
 */
@Data
public class FieldTemplate {
  
  private String name;
  private String type;
  private FieldSpec staticAnnotation;

  public FieldTemplate(String name, String type, FieldSpec staticAnnotation) {
    this.name = name;
    this.type = type;
    this.staticAnnotation = staticAnnotation;
  }

  public FieldTemplate(String name, String type) {
    this.name = name;
    this.type = type;
  }

  public static Map<String, ClassName> getFieldFAnnotation(String type){
      Map<String, ClassName> map = new HashMap<>();
      map.put("Size", new Size().getContent());
      map.put("ManyToMany", new ManyToMany().getContent());
      map.put("ManyToOne", new ManyToOne().getContent());
      map.put("OneToMany", new OneToMany().getContent());
      map.put("OneToOne", new OneToOne().getContent());
      return map;
  }

}
