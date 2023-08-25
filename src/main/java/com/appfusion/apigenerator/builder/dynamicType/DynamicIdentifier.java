package com.appfusion.apigenerator.builder.dynamicType;

import java.util.Map;

public class DynamicIdentifier {

  public static Class<?> identifyType(String type) {
    Map<String, Class<?>> types = DynamicType.getDynamicType();
    Class<?> result = null;

    if (types.containsKey(type)) {
      result = types.get(type);
    }
    return result;
  }

}
