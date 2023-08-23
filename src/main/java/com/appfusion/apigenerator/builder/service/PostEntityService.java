package com.appfusion.apigenerator.builder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appfusion.apigenerator.builder.codegenerator.PostGenerator;
import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.repositories.PostEntityRepository;

@Service
public class PostEntityService {

  @Autowired
  private PostEntityRepository repository;

  public PostEntityService(PostEntityRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<PostEntity> saveEntity(String requestBody) {
    PostEntity entity = new PostEntity();
    entity.setEntity(requestBody);
    return new ResponseEntity<PostEntity>(repository.save(entity), HttpStatus.OK);
  }

  public ResponseEntity<PostEntity> generateEntity(Long id) throws Exception {
    String entityContent = getEntityContentById(id);
    PostGenerator generator = new PostGenerator();
    generator.generateDynamicEntity(entityContent);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  public String getEntityContentById(Long id) {
    Optional<PostEntity> postEntity = repository.findById(id);
    PostEntity entity = null;
    if (postEntity.isPresent()) {
      entity = postEntity.get();
    }
    return entity.getEntity();
  }

}
