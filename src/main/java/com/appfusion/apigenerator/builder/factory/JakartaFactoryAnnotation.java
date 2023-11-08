package com.appfusion.apigenerator.builder.factory;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.DTOs.EntityDTO;
import com.appfusion.apigenerator.builder.dynamicType.DynamicType;
import com.appfusion.apigenerator.builder.interfaces.AdditionalAnnotations;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.AnnotationTemplate;
import com.squareup.javapoet.ClassName;


public class JakartaFactoryAnnotation implements AdditionalAnnotations {

  private static Logger LOG = LoggerFactory.getLogger(JakartaFactoryAnnotation.class);

  @Override
  public Map<ClassName, Map<String, String>> additionalAnnotations(String json) {
    try {
      System.out.println(getannotationType(json));
    } catch (Exception e) {
      LOG.info("Json without dynamicAnnotations present.");
    }
    return null;
  }

  public Map<ClassName, Map<String, String>> getannotationType(String json) {
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

}
