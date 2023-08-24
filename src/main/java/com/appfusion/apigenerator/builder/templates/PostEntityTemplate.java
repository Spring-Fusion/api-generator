package com.appfusion.apigenerator.builder.templates;

import java.util.List;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostEntityTemplate {

  private ClassName entityAnnotation;
  private ClassName idAnnotation;
  private ClassName dataAnnotation;
  private ClassName generatedValueAnnotation;
  private ClassName generationTypeAnnotation;
  private List<FieldSpec> fields;

  public PostEntityTemplate(ClassName entityAnnotation, ClassName idAnnotation, ClassName dataAnnotation,
      ClassName generatedValueAnnotation, ClassName generationTypeAnnotation, List<FieldSpec> fields) {
    this.entityAnnotation = entityAnnotation;
    this.idAnnotation = idAnnotation;
    this.dataAnnotation = dataAnnotation;
    this.generatedValueAnnotation = generatedValueAnnotation;
    this.generationTypeAnnotation = generationTypeAnnotation;
    this.fields = fields;
  }

}
