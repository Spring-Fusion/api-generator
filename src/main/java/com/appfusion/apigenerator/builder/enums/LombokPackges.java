package com.appfusion.apigenerator.builder.enums;

/**
 * This enum represents the Lombok packages available in the application.
 * 
 * @author Gabriel Reis
 */
public enum LombokPackges {
  
  Data("Data");

  public String value;
  
  private LombokPackges(String value){
    this.value = value;
  }

}
