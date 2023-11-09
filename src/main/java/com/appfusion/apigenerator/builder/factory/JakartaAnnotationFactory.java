package com.appfusion.apigenerator.builder.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.interfaces.AdditionalAnnotations;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.AnnotationTemplate;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

/**
 * This class implements the AdditionalAnnotations interface and provides
 * additional annotations using the Jakarta annotations.
 * It contains methods to retrieve annotation types and parameters from a JSON
 * object, and to generate additional annotations.
 * 
 * @author Gabriel Reis
 */
public class JakartaAnnotationFactory implements AdditionalAnnotations {

  private static Logger LOG = LoggerFactory.getLogger(JakartaAnnotationFactory.class);

  @Override
  public Map<ClassName, Map<String, String>> additionalAnnotations(String json) {
    Map<ClassName, Map<String, String>> result = null;
    try {
      result = getAnnotationType(json);
    } catch (Exception e) {
      LOG.info("Json without dynamicAnnotations present.");
    }
    return result;
  }

  public Map<ClassName, Map<String, String>> getAnnotationType(String json) {
    JSONObject object = EntityUtil.getJsonInstance(EntityUtil.getJsonValue(json, "dynamicAnnotations"));
    Map<ClassName, Map<String, String>> result = new HashMap<>();
    for (Object value : object.keySet()) {
      result.put(getClassName(value.toString()), getAnnotationParameters(object));
    }
    return result;
  }

  public ClassName getClassName(String className) {
    Map<String, ClassName> types = AnnotationTemplate.getAnnotations();
    ClassName result = null;
    if (types.containsKey(className)) {
      result = types.get(className);
    }
    return result;
  }

  public Map<String, String> getAnnotationParameters(JSONObject json) {
    Map<String, String> result = new HashMap<>();
    for (Object value : json.keySet()) {
      JSONObject parameterObject = EntityUtil
          .getJsonInstance(EntityUtil.getJsonValue(json.toString(), value.toString()));
      for (Object parameter : parameterObject.keySet()) {
        result.put(parameter.toString(), parameterObject.get(parameter.toString()).toString());
      }
    }
    return result;
  }

  public List<AnnotationSpec> generateAdditionalAnnotation(String json) {
    Map<ClassName, Map<String, String>> annotations = additionalAnnotations(json);
    List<AnnotationSpec> result = new ArrayList<>();
    for (Object value : annotations.keySet()) {
      AnnotationSpec.Builder builder = AnnotationSpec.builder((ClassName) value);
      for (Object parameter : annotations.get(value).keySet()) {
        builder.addMember(parameter.toString(), "$S", annotations.get(value).get(parameter.toString()));
      }
      result.add(builder.build());
    }
    return result;
  }
   

}
