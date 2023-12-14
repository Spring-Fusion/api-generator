package com.appfusion.apigenerator.builder.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.codegenerator.ControllerGenerator;
import com.appfusion.apigenerator.builder.dynamicType.DynamicIdentifier;
import com.appfusion.apigenerator.builder.factory.FieldFactory;
import com.appfusion.apigenerator.builder.templates.FieldTemplate;
import com.appfusion.apigenerator.builder.templates.ModelTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;

/**
 * This class provides utility methods for working with entity objects.
 * 
 * @author Gabriel Reis
 */
public class EntityUtil {

  private static Logger LOG = LoggerFactory.getLogger(ControllerGenerator.class);

  public static List<FieldSpec> getFields(String json, ModelTemplate entityTemplate) {
    Map<Object, Object> fields = getEntityFields(getJsonInstance(EntityUtil.getJsonValue(json, "entity")));
    List<FieldSpec> list = new ArrayList<>();
    FieldSpec fieldSpec = FieldFactory.getIdFieldSpec(entityTemplate);
    list.add(fieldSpec);

    for (Object field : fields.keySet()) {
      String type = getJsonValue(fields.get(field.toString()).toString(), "type");
      String staticAnnotation = getParameterFromField(fields.get(field.toString()).toString(), "staticAnnotation",field.toString());
      if (staticAnnotation != null) {
        AnnotationSpec annotationSpec = getStaticAnnotationFromField(staticAnnotation);
        fieldSpec = FieldSpec.builder(DynamicIdentifier.identifyType(type), field.toString()).addModifiers(Modifier.PRIVATE).addAnnotation(annotationSpec).build();
      } else {
        fieldSpec = FieldSpec.builder(DynamicIdentifier.identifyType(type), field.toString()).addModifiers(Modifier.PRIVATE).build();
      }
      list.add(fieldSpec);
    }
    return list;
  }

  public static AnnotationSpec getStaticAnnotationFromField(String name) {
    Map<String, ClassName> map = FieldTemplate.getFieldFAnnotation(name);
    AnnotationSpec result = AnnotationSpec.builder(map.get(name)).build();
    return result;
  }

  public static String getJsonValue(String json, String key) {
    return getJsonInstance(json).get(key).toString();
  }

  public static String getParameterFromField(String json, String parameter, String field) {
    String result = null;
    try {
      result = getJsonInstance(json).get(parameter).toString();
    } catch (Exception e) {
      LOG.error("Field: " + field + ", does not have a static annotation");
    }
    return result;
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

    getAndSet.append("if(object.isPresent()){");
    getAndSet.append("\n");
    getAndSet.append(EntityUtil.getJsonValue(dto.getJson(), "entityName") + " objectToUpdate = object.get();");
    for (Object value : fields.keySet()) {
      String field = capitalizeFirstLetter(value.toString());
      getAndSet.append("\n");
      getAndSet.append("objectToUpdate" + "."
          + "set"
          + field + "(" + "entity" + "." + "get" + field + "());");
    }
    getAndSet.append("\n");
    getAndSet.append("repository.save(objectToUpdate);");
    getAndSet.append("}");
    return getAndSet.toString();
  }

  public static String capitalizeFirstLetter(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
  }

}