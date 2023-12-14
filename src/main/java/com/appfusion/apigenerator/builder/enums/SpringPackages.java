package com.appfusion.apigenerator.builder.enums;

/**
 * Enum class representing common Spring packages used in the project.
 * 
 * ]@author Gabriel Reis
 */
public enum SpringPackages {

  JakartaPersistence("jakarta.persistence"),
  JpaRepository("org.springframework.data.jpa.repository"),
  WebBind("org.springframework.web.bind.annotation"),
  BeansFactory("org.springframework.beans.factory.annotation"),
  Lombok("lombok"),
  ValidationConstraints("jakarta.validation.constraints");
  
  public String value;
  
  private SpringPackages(String value) {
    this.value = value;
  }
  
  
}
