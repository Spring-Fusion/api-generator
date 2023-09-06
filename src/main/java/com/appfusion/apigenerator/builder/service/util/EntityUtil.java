package com.appfusion.apigenerator.builder.service.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class EntityUtil {

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
