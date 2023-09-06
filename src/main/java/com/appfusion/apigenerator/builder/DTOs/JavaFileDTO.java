package com.appfusion.apigenerator.builder.DTOs;

import com.squareup.javapoet.TypeSpec;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JavaFileDTO {
      
  private String jsonPackage;  
  private TypeSpec spec;
  private String clientID;

  public JavaFileDTO(String jsonPackage, TypeSpec spec, String clientID) {
    this.jsonPackage = jsonPackage;
    this.spec = spec;
    this.clientID = clientID;
  }
}
