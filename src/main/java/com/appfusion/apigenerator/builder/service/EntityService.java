package com.appfusion.apigenerator.builder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appfusion.apigenerator.builder.codegenerator.EntityGenerator;
import com.appfusion.apigenerator.builder.entities.ModelEntity;
import com.appfusion.apigenerator.builder.repositories.EntityRepository;

/**
 * This class represents a service for managing entities.
 * 
 * @author Gabriel Reis
 */
@Service
public class EntityService {

  @Autowired
  private EntityRepository repository;

  public EntityService(EntityRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<ModelEntity> saveEntity(String requestBody) {
    ModelEntity entity = new ModelEntity();
    entity.setEntity(requestBody);
    return new ResponseEntity<ModelEntity>(repository.save(entity), HttpStatus.OK);
  }

  public ResponseEntity<ModelEntity> generateEntity(Long id) throws Exception {
    String entityContent = getEntityContentById(id);
    EntityGenerator generator = new EntityGenerator();
    generator.generateDynamicEntity(entityContent);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  public String getEntityContentById(Long id) {
    Optional<ModelEntity> postEntity = repository.findById(id);
    ModelEntity entity = null;
    String result = null;
    if (postEntity.isPresent()) {
      entity = postEntity.get();
    }

    if (entity != null) {
      result = entity.getEntity();
    }
    return result;
  }

}
