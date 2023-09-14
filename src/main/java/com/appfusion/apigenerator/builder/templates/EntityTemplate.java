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

@Data
@NoArgsConstructor
public class EntityTemplate {
  
  private ClassName entityAnnotation;
  private ClassName idAnnotation;
  private ClassName dataAnnotation;
  private ClassName generatedValueAnnotation;
  private ClassName generationTypeAnnotation;
  private ClassName columnAnnotation;

  public EntityTemplate(ClassName entityAnnotation, ClassName idAnnotation, ClassName dataAnnotation,
      ClassName generatedValueAnnotation, ClassName generationTypeAnnotation, ClassName columnAnnotation) {
      this.entityAnnotation = entityAnnotation;
      this.idAnnotation = idAnnotation;
      this.dataAnnotation = dataAnnotation;
      this.generatedValueAnnotation = generatedValueAnnotation;
      this.generationTypeAnnotation = generationTypeAnnotation;
      this.columnAnnotation = columnAnnotation;
  }
  
  public static EntityTemplate getPostTemplate() {
    EntityTemplate postTemplate = new EntityTemplate(
      new EntityClassName().getContent(),
      new IdClassName().getContent(), 
      new LombokDataClassName().getContent(),
      new GeneratedValueClassName().getContent(), 
      new GenerationTypeClassName().getContent(),
      new ColumnClassName().getContent());
    return postTemplate;
  }

}
