package com.appfusion.apigenerator.builder.templates;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.entityContent.EntityClassName;
import com.appfusion.apigenerator.builder.entityContent.GeneratedValueClassName;
import com.appfusion.apigenerator.builder.entityContent.GenerationTypeClassName;
import com.appfusion.apigenerator.builder.entityContent.IdClassName;
import com.appfusion.apigenerator.builder.entityContent.LombokDataClassName;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.service.util.PostUtil;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

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

  public PostEntityTemplate(ClassName entityAnnotation, ClassName idAnnotation, ClassName dataAnnotation,
      ClassName generatedValueAnnotation, ClassName generationTypeAnnotation) {
    this.entityAnnotation = entityAnnotation;
    this.idAnnotation = idAnnotation;
    this.dataAnnotation = dataAnnotation;
    this.generatedValueAnnotation = generatedValueAnnotation;
    this.generationTypeAnnotation = generationTypeAnnotation;
  }
  
  public static PostEntityTemplate getPostTemplate() {
    PostEntityTemplate postTemplate = new PostEntityTemplate(
        new EntityClassName().getContent(),
        new IdClassName().getContent(), 
        new LombokDataClassName().getContent(),
        new GeneratedValueClassName().getContent(), 
        new GenerationTypeClassName().getContent());
    return postTemplate;
  }
  
  public static TypeSpec getPostTypeSpec(String json, PostEntityTemplate entityTemplate) {
    return TypeSpec
    .classBuilder(EntityUtil.getJsonEntityName(json))
    .addModifiers(Modifier.PUBLIC)
    .addAnnotation(PostUtil.getEntityAnnotationSpec(entityTemplate))
    .addAnnotation(PostUtil.getDataLombokAnntotationSpec(entityTemplate))
    .addFields(PostUtil.getFields(json, entityTemplate)).build();
  }


}
