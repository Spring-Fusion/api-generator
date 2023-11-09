package com.appfusion.apigenerator.builder.interfaces;

import java.util.Map;

import com.squareup.javapoet.ClassName;

/**
 * This interface defines a method to retrieve additional annotations from a JSON string.
 * 
 * @author Gabriel Reis
 */
public interface AdditionalAnnotations {

  /**
   * Retrieves additional annotations from a JSON string.
   * @param json the JSON string containing the annotations.
   * @return a map of class names to a map of annotation names and values.
   */
  Map<ClassName, Map<String, String>> additionalAnnotations(String json);

}
