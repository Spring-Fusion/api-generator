package com.appfusion.apigenerator.builder.templates;

import com.appfusion.apigenerator.builder.entityContent.ColumnClassName;
import com.appfusion.apigenerator.builder.entityContent.EntityClassName;
import com.appfusion.apigenerator.builder.entityContent.GeneratedValueClassName;
import com.appfusion.apigenerator.builder.entityContent.GenerationTypeClassName;
import com.appfusion.apigenerator.builder.entityContent.IdClassName;
import com.appfusion.apigenerator.builder.entityContent.LombokDataClassName;
import com.squareup.javapoet.ClassName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a template for generating a model class with
 * annotations.
 * 
 * @author Gabriel Reis
 */
@Data
@NoArgsConstructor
public class ModelTemplate {

  private ClassName entityAnnotation;
  private ClassName idAnnotation;
  private ClassName dataAnnotation;
  private ClassName generatedValueAnnotation;
  private ClassName generationTypeAnnotation;
  private ClassName columnAnnotation;

  public ModelTemplate(ClassName entityAnnotation, ClassName idAnnotation, ClassName dataAnnotation,
      ClassName generatedValueAnnotation, ClassName generationTypeAnnotation, ClassName columnAnnotation) {
    this.entityAnnotation = entityAnnotation;
    this.idAnnotation = idAnnotation;
    this.dataAnnotation = dataAnnotation;
    this.generatedValueAnnotation = generatedValueAnnotation;
    this.generationTypeAnnotation = generationTypeAnnotation;
    this.columnAnnotation = columnAnnotation;
  }

  public static ModelTemplate getModelTemplate() {
    ModelTemplate postTemplate = new ModelTemplate(
        new EntityClassName().getContent(),
        new IdClassName().getContent(),
        new LombokDataClassName().getContent(),
        new GeneratedValueClassName().getContent(),
        new GenerationTypeClassName().getContent(),
        new ColumnClassName().getContent());
    return postTemplate;
  }

}
