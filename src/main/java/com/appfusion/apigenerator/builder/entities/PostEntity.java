package com.appfusion.apigenerator.builder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String entity;

  public PostEntity(String entity) {
    this.entity = entity;
  }
  
  public PostEntity() {
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

}
