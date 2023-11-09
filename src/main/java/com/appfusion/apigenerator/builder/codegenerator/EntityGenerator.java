package com.appfusion.apigenerator.builder.codegenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appfusion.apigenerator.builder.entities.ModelEntity;

/**
 * This class is responsible for generating dynamic entities based on a JSON
 * input.
 * It uses ModelGenerator, RepositoryGenerator, and ControllerGenerator to
 * generate the necessary components.
 * 
 * @author Gabriel Reis
 */
public class EntityGenerator {

  public ResponseEntity<ModelEntity> generateDynamicEntity(String json) throws Exception {
    ModelGenerator.generateModel(json);
    RepositoryGenerator.generateRepository(json);
    ControllerGenerator.generateController(json);
    RepositoryGenerator.generateRepository(json);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
