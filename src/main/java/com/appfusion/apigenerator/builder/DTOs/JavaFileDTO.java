package com.appfusion.apigenerator.builder.DTOs;

import com.squareup.javapoet.TypeSpec;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a Data Transfer Object for a Java file, containing
 * information about its package, TypeSpec and client ID.
 * 
 * @author Gabriel Reis
 */
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
