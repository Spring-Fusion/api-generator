package com.appfusion.apigenerator.builder.interfaces;

import java.util.Map;

import com.squareup.javapoet.ClassName;

public interface AdditionalAnnotations {

  Map<ClassName, Map<String, String>> additionalAnnotations(String json);

} 
