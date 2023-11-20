package com.appfusion.apigenerator.builder.codegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appfusion.apigenerator.builder.entities.ModelEntity;

/**
 * This class is responsible for generating dynamic entities based on a JSON
 * input.
 * It uses ModelGenerator, RepositoryGenerator, and ControllerGenerator to
 * generate the necessary components.
 * 
 * © Spring Fusion 2023
 * 
 * @author Gabriel Reis
 */
public class EntityGenerator {

  private static Logger LOG = LoggerFactory.getLogger(EntityGenerator.class);

  /**
   * Generates a dynamic entity based on the provided JSON.
   *
   * @param json the JSON string representing the entity
   * @return a ResponseEntity containing the generated ModelEntity
   * @throws Exception if an error occurs during the generation process
   */
  public ResponseEntity<ModelEntity> generateDynamicEntity(String json) {
    try {
      ModelGenerator.generateModel(json);
      RepositoryGenerator.generateRepository(json);
      ControllerGenerator.generateController(json);
      RepositoryGenerator.generateRepository(json);
      LOG.info("Dynamic entity generated successfully");
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      LOG.error("Error generating dynamic entity: " + e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
