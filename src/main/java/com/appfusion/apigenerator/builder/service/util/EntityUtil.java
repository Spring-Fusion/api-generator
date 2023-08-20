package com.appfusion.apigenerator.builder.service.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class EntityUtil {

  public Object getEntityFromJson(String json) {
    JSONObject jsonObject = new JSONObject(json);
    return jsonObject.get("entity");
  }

  public Object getEntityNameFromJson(Object object) {
    return getJsonInstance(object).get("entityName");
  }

  public Object getEndPointName(Object object) {
    return getJsonInstance(object).get("endPointName");
  }

  public JSONObject getJsonInstance(Object object) {
    return new JSONObject(object.toString());
  }

  public Map<Object, Object> getEntityFields(JSONObject jsonObject) {
    Map<Object, Object> result = new HashMap<>();
    for (Object json : jsonObject.keySet()) {
      result.put(json, jsonObject.get(json.toString()));
    }
    return result;
  }

}
