package com.appfusion.apigenerator.builder.codegenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appfusion.apigenerator.builder.entities.PostEntity;

public class EntityGenerator {
  public ResponseEntity<PostEntity> generateDynamicEntity(String json) throws Exception {
    PostGenerator.generatePost(json);
    RepositoryGenerator.generateRepository(json);
    ControllerGenerator.generateController(json);
    RepositoryGenerator.generateRepository(json);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
