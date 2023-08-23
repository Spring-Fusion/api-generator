package com.appfusion.apigenerator.builder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Entity
@Data
public class Aluno {
  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO
  )
  private Long id;

  private String name;

  private String age;

  private String email;
}
