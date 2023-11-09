package com.appfusion.apigenerator.builder.dynamicType;

import java.util.Map;

import com.appfusion.apigenerator.builder.interfaces.AbstractType;

/**
 * This class provides a method to identify a dynamic type based on a given
 * string.
 * It is used by the DynamicType class.
 * 
 * @see DynamicType
 * @see AbstractType
 * @author Gabriel Reis
 * 
 */
public class DynamicIdentifier {

  /**
   * Identifies a dynamic type based on a given string.
   * 
   * @param type the string representation of the dynamic type
   * @return the Class object representing the dynamic type, or null if the type
   *         is not found
   */
  public static Class<?> identifyType(String type) {
    Map<String, Class<?>> types = DynamicType.getDynamicType();
    Class<?> result = null;
    if (types.containsKey(type)) {
      result = types.get(type);
    }
    return result;
  }

}
