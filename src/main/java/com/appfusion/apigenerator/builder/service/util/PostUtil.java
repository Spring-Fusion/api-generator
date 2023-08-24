package com.appfusion.apigenerator.builder.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;

public class PostUtil {
  
  public static AnnotationSpec getEntityAnnotationSpec(PostEntityTemplate postTemplate) {
    return AnnotationSpec.builder(postTemplate.getEntityAnnotation()).build();
  }
  
  public static AnnotationSpec getDataLombokAnntotationSpec(PostEntityTemplate postTemplate) {
    return AnnotationSpec.builder(postTemplate.getDataAnnotation()).build();
  }

  public static List<FieldSpec> getFields(String json, PostEntityTemplate entityTemplate) {
    Map<Object, Object> fields = EntityUtil.getEntityFields(EntityUtil.getJsonInstance(EntityUtil.getJsonEntity(json)));
    List<FieldSpec> list = new ArrayList<>();
    FieldSpec fieldSpec = getIdFieldSpec(entityTemplate);
    list.add(fieldSpec);
    for (Object field : fields.keySet()) {
      
      fieldSpec = FieldSpec
          .builder(String.class, field.toString())
          .addModifiers(Modifier.PRIVATE)
          .build();
      
      list.add(fieldSpec);
    }
    return list;
  }
  
  public static FieldSpec getIdFieldSpec(PostEntityTemplate postTemplate) {
    
    AnnotationSpec id = AnnotationSpec
        .builder(postTemplate.getIdAnnotation())
        .build();
    
    AnnotationSpec generatedValue = AnnotationSpec
        .builder(postTemplate.getGeneratedValueAnnotation())
        .addMember("strategy", "$T.AUTO", postTemplate.getGenerationTypeAnnotation())
        .build();
    
    FieldSpec fieldSpec = FieldSpec
        .builder(Long.class, "id")
        .addModifiers(Modifier.PRIVATE).
        addAnnotation(id)
        .addAnnotation(generatedValue)
        .build();
    
    return fieldSpec;
  }
}
