package com.appfusion.apigenerator.builder.enums;

public enum SpringPackages {

  JakartaPersistence("jakarta.persistence"),
  JpaRepository("org.springframework.data.jpa.repository"),
  WebBind("org.springframework.web.bind.annotation"),
  BeansFactory("org.springframework.beans.factory.annotation"),
  Lombok("lombok");
  
  public String value;
  
  private SpringPackages(String value) {
    this.value = value;
  }
  
  
}
