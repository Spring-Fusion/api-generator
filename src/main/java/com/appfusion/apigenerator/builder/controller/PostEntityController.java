package com.appfusion.apigenerator.builder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.service.PostEntityService;

@RestController
@RequestMapping("/entity")
public class PostEntityController {
  
  private PostEntityService service;
  
  public PostEntityController(PostEntityService service) {this.service = service;}
  
  @PostMapping("/saveEntity")
  public ResponseEntity<PostEntity> saveEntityReq(@RequestBody String entity){
    return service.saveEntity(entity);
  }
  
  @PostMapping("/createEntity")
  public void generatePostEntity(@RequestBody Long id) {
    System.out.println(service.generateEntity(id));
  }
  
}
