package com.appfusion.apigenerator.builder.service.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class EntityUtil {

  public String getJsonEntity(String json) {
    return getJsonInstance(json).get("entity").toString();
  }

  public String getJsonEntityName(String json) {
    return getJsonInstance(json).get("entityName").toString();
  }

  public String getJsonEndPoint(String json) {
    return getJsonInstance(json).get("endPointName").toString();
  }

  public String getJsonPackage(String json) {
    return getJsonInstance(json).get("package").toString();
  }

  public String getTypeFromField(String json) {
    return getJsonInstance(json).get("type").toString();
  }

  public JSONObject getJsonInstance(String json) {
    return new JSONObject(json);
  }

  public Map<Object, Object> getEntityFields(JSONObject jsonObject) {
    Map<Object, Object> result = new HashMap<>();
    for (Object json : jsonObject.keySet()) {
      result.put(json, jsonObject.get(json.toString()));
    }
    return result;
  }

}
