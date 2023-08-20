package com.appfusion.apigenerator.builder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.repositories.PostEntityRepository;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;

@Service
public class PostEntityService {

  @Autowired
  private PostEntityRepository repository;

  public PostEntityService(PostEntityRepository repository) {
    this.repository = repository;
  }

  public ResponseEntity<PostEntity> saveEntity(String requestBody) {
    PostEntity entity = new PostEntity(requestBody);
    return new ResponseEntity<PostEntity>(repository.save(entity), HttpStatus.OK);
  }
  
  public Object generateEntity(Long id) {
     String test = getEntityContentById(id);
     new EntityUtil().getEntityNameFromJson(test);
     return null;
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
