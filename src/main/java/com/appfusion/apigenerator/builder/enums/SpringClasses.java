package com.appfusion.apigenerator.builder.enums;

public enum SpringClasses {
 
  Data("Data"),
  JpaRepository("JpaRepository"),
  PostMapping("PostMapping"),
  GetMapping("GetMapping"),
  DeleteMapping("DeleteMapping"),
  PutMapping("PutMapping"),
  RequestBody("RequestBody"),
  Autowired("Autowired"),
  PathVariable("PathVariable"),
  RestController("RestController");
  
  public String value;
  
  private SpringClasses(String value) {
    this.value = value;
  }
  
}
