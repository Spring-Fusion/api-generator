package com.appfusion.apigenerator.builder.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.json.JSONObject;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.dynamicType.DynamicIdentifier;
import com.appfusion.apigenerator.builder.factory.AnnotationFactory;
import com.appfusion.apigenerator.builder.factory.FieldFactory;
import com.appfusion.apigenerator.builder.templates.EntityTemplate;
import com.squareup.javapoet.FieldSpec;

public class EntityUtil {

  public static List<FieldSpec> getFields(String json, EntityTemplate entityTemplate) {
    Map<Object, Object> fields = getEntityFields(getJsonInstance(EntityUtil.getJsonValue(json, "entity")));
    List<FieldSpec> list = new ArrayList<>();
    FieldSpec fieldSpec = FieldFactory.getIdFieldSpec(entityTemplate);
    list.add(fieldSpec);

    for (Object field : fields.keySet()) {
      String type = getJsonValue(fields.get(field.toString()).toString(), "type");
      String size = getSizeFromField((fields.get(field.toString()).toString()));
      com.squareup.javapoet.AnnotationSpec column = AnnotationFactory.getFieldSizeAnnotation(entityTemplate, size);
      if (column != null) {
        fieldSpec = FieldSpec.builder(DynamicIdentifier.identifyType(type), field.toString())
            .addModifiers(Modifier.PRIVATE).addAnnotation(column).build();
      } else {
        fieldSpec = FieldSpec.builder(DynamicIdentifier.identifyType(type), field.toString())
            .addModifiers(Modifier.PRIVATE).build();
      }

      list.add(fieldSpec);
    }
    return list;
  }

  public static String getJsonValue(String json, String key) {
    return getJsonInstance(json).get(key).toString();
  }

  public static String getSizeFromField(String json) {
    try {
      return getJsonInstance(json).get("size").toString();
    } catch (Exception e) {
      return null;
    }
  }

  public static JSONObject getJsonInstance(String json) {
    return new JSONObject(json);
  }

  public static Map<Object, Object> getEntityFields(JSONObject jsonObject) {
    Map<Object, Object> result = new HashMap<>();
    for (Object json : jsonObject.keySet()) {
      result.put(json, jsonObject.get(json.toString()));
    }
    return result;
  }

  public static String generateEntityGetAndSet(EntityDTO dto) {
    Map<Object, Object> fields = getEntityFields(getJsonInstance(EntityUtil.getJsonValue(dto.getJson(), "entity")));
    StringBuilder getAndSet = new StringBuilder();

    for (Object value : fields.keySet()) {
      String field = capitalizeFirstLetter(value.toString());
      getAndSet.append(dto.getTemplate().getRunTimeEntityClass() + "."
          + "set"
          + field + "(" + dto.getTemplate().getRunTimeEntityClass() + "." + "get" + field + "())\n");
    }
    return getAndSet.toString();
  }

  public static String capitalizeFirstLetter(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
  }

}
