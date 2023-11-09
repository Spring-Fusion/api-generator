package com.appfusion.apigenerator.builder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Represents a model entity in the application.
 * This class is used to store the model entities in the database.
 * 
 * @author Gabriel Reis
 */
@Entity
@Data
public class ModelEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length = 1000000)
  private String entity;
}
