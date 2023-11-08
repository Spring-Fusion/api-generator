package com.appfusion.apigenerator.builder.factory;

import java.util.ArrayList;
import java.util.List;
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
      //String value = EntityUtil.getJsonValue(json, "dynamicAnnotations");
      //System.out.println(value);
      getannotationType(json);
    } catch (Exception e) {
      LOG.info("Json without dynamicAnnotations present.");
    }
    return null;
  }
  public List<ClassName> getannotationType(String json){
    JSONObject object = EntityUtil.getJsonInstance(EntityUtil.getJsonValue(json, "dynamicAnnotations"));
    List<ClassName> result = new ArrayList<>();

    for(Object value: object.keySet()){
        System.out.println(value);
        System.out.println(object.get(value.toString()));
    }

    return null;
  }
  
  public ClassName classIdentifier(String className){
    Map<String , ClassName> types = AnnotationTemplate.getAnnotations();
    ClassName result = null;
    if (types.containsKey(className)) {
      result = types.get(className);
    }
    return result;
  }

}
