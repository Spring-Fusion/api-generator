package com.appfusion.apigenerator.builder.enums;

public enum SpringClasses {
 
  Entity("Entity"),
  Id("Id"),
  Data("Data"),
  GeneratedValue("GeneratedValue"),
  GenerationType("GenerationType"),
  JpaRepository("JpaRepository"),
  PostMapping("PostMapping"),
  GetMapping("GetMapping"),
  DeleteMapping("DeleteMapping"),
  RequestBody("RequestBody"),
  Autowired("Autowired"),
  PathVariable("PathVariable"),
  RestController("RestController"),
  Column("Column");
  
  
  public String value;
  
  private SpringClasses(String value) {
    this.value = value;
  }
  
}
