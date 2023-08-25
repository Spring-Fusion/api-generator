package com.appfusion.apigenerator.builder.enums;

public enum Packages {

  Repositories(".repositories"),
  Controller(".controller"),
  Entities(".entities");
  
  public String value;
  
  private Packages(String value) {
    this.value = value;
  }
  
}
