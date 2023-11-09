package com.appfusion.apigenerator.builder.enums;

/**
 * Enum representing the packages used in the application.
 * 
 * @author Gabriel Reis
 */
public enum Packages {

  Repositories(".repositories"),
  Controller(".controller"),
  Entities(".entities");

  public String value;
  
  private Packages(String value) {
    this.value = value;
  }

}
