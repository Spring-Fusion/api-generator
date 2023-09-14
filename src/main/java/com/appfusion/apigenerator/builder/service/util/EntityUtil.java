package com.appfusion.apigenerator.builder.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.json.JSONObject;

import com.appfusion.apigenerator.builder.dynamicType.DynamicIdentifier;
import com.appfusion.apigenerator.builder.factory.AnnotationFactory;
import com.appfusion.apigenerator.builder.factory.FieldFactory;
import com.appfusion.apigenerator.builder.templates.EntityTemplate;
import com.squareup.javapoet.FieldSpec;

public class EntityUtil {

  public static List<FieldSpec> getFields(String json, EntityTemplate entityTemplate) {
    Map<Object, Object> fields = getEntityFields(getJsonInstance(EntityUtil.getJsonEntity(json)));
    List<FieldSpec> list = new ArrayList<>();
    FieldSpec fieldSpec = FieldFactory.getIdFieldSpec(entityTemplate);
    list.add(fieldSpec);

    for (Object field : fields.keySet()) {
      String type = getTypePropertiesFromField(fields.get(field.toString()).toString());
      String size = getSizeFromField((fields.get(field.toString()).toString()));
      com.squareup.javapoet.AnnotationSpec column = AnnotationFactory.getFieldSizeAnnotation(entityTemplate, size);
      if (column != null) {
        fieldSpec = 
                 FieldSpec
                 .builder(DynamicIdentifier.identifyType(type), field.toString())
                 .addModifiers(Modifier.PRIVATE)
                 .addAnnotation(column)
                 .build();
      }else {
        fieldSpec = 
            FieldSpec
            .builder(DynamicIdentifier.identifyType(type), field.toString())
            .addModifiers(Modifier.PRIVATE)
            .build();
      }
      
      list.add(fieldSpec);
    }
    return list;
  }
  
  public static String getTypePropertiesFromField(String field) {
    return EntityUtil.getTypeFromField(field);
  }

  public static String getJsonEntity(String json) {
    return getJsonInstance(json).get("entity").toString();
  }

  public static String getJsonEntityName(String json) {
    return getJsonInstance(json).get("entityName").toString();
  }

  public static String getJsonEndPoint(String json) {
    return getJsonInstance(json).get("endPointName").toString();
  }

  public static String getJsonPackage(String json) {
    return getJsonInstance(json).get("package").toString();
  }

  public static String getTypeFromField(String json) {
    return getJsonInstance(json).get("type").toString();
  }
  
  public static String getSizeFromField(String json) {
    try {
      return getJsonInstance(json).get("size").toString();
    } catch (Exception e) {
      return null;
    }
  }

  public static String getClientIDFromJson(String json) {
    return getJsonInstance(json).get("clientID").toString();
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

}
