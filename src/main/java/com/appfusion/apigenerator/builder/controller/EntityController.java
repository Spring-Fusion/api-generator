package com.appfusion.apigenerator.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.PostEntityService;

@RestController
@RequestMapping("/entity")
public class EntityController {

  @Autowired
  private PostEntityService service;

  public EntityController(PostEntityService service) {
    this.service = service;
  }

  @PostMapping("/saveEntity")
  public ResponseEntity<PostEntity> saveEntityReq(@RequestBody String entity) {
    return service.saveEntity(entity);
  }

  @PostMapping("/createEntity/{id}")
  public void generatePostEntity(@PathVariable Long id) throws Exception {
    service.generateEntity(id);
  }

  @PostMapping("/generateProject")
  public void generateProject(@RequestBody String clientId) throws Exception {
    ResourceLoader.generateNewProject(clientId);
  }

  @PostMapping("/publishProject")
  public void publishProject(@RequestBody String clientId) throws Exception{
    ResourceLoader.publishProject(clientId);
  }

  @PostMapping("/cleanProjectContent")
  public void cleanProjectContent(@RequestBody String clientId) throws Exception{
    ResourceLoader.cleanProjectContent(clientId);
  }
}
