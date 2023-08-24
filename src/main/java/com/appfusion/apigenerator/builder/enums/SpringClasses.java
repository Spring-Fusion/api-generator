package com.appfusion.apigenerator.builder.enums;

public enum SpringClasses {
 
  Entity("Entity"),
  Id("Id"),
  Data("Data"),
  GeneratedValue("GeneratedValue"),
  GenerationType("GenerationType"),
  JpaRepository("JpaRepository"),
  PostMapping("PostMapping"),
  RequestBody("RequestBody"),
  Autowired("Autowired"),
  RestController("RestController");
  
  
  public String value;
  
  private SpringClasses(String value) {
    this.value = value;
  }
  
}
