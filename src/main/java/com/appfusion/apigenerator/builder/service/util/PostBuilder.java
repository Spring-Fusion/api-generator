package com.appfusion.apigenerator.builder.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.dynamicType.DynamicIdentifier;
import com.appfusion.apigenerator.builder.factory.AnnotationFactory;
import com.appfusion.apigenerator.builder.factory.FieldFactory;
import com.appfusion.apigenerator.builder.templates.PostEntityTemplate;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;

public class PostBuilder {

  public static List<FieldSpec> getFields(String json, PostEntityTemplate entityTemplate) {
    Map<Object, Object> fields = EntityUtil.getEntityFields(EntityUtil.getJsonInstance(EntityUtil.getJsonEntity(json)));
    List<FieldSpec> list = new ArrayList<>();
    FieldSpec fieldSpec = FieldFactory.getIdFieldSpec(entityTemplate);
    list.add(fieldSpec);

    for (Object field : fields.keySet()) {
      String type = getTypePropertiesFromField(fields.get(field.toString()).toString());
      fieldSpec = FieldSpec
          .builder(DynamicIdentifier.identifyType(type), field.toString())
          .addModifiers(Modifier.PRIVATE)
          .build();
      list.add(fieldSpec);
    }
    return list;
  }

  public static String getTypePropertiesFromField(String field) {
    return EntityUtil.getTypeFromField(field);
  }

  public static TypeSpec getPostTypeSpec(String json, PostEntityTemplate entityTemplate) {
    return TypeSpec
        .classBuilder(EntityUtil.getJsonEntityName(json))
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(AnnotationFactory.getEntityAnnotationSpec(entityTemplate))
        .addAnnotation(AnnotationFactory.getDataLombokAnntotationSpec(entityTemplate))
        .addFields(PostBuilder.getFields(json, entityTemplate)).build();
  }
}
