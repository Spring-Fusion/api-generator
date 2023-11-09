package com.appfusion.apigenerator.builder.enums;

/**
 * Enum containing commonly used Spring classes.
 * 
 * @author Gabriel Reis
 */
public enum SpringClasses {
  
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
