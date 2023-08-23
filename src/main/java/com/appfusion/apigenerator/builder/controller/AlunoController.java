package com.appfusion.apigenerator.builder.controller;

import com.appfusion.apigenerator.builder.entities.Aluno;
import com.appfusion.apigenerator.builder.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
  @Autowired
  private AlunoRepository repository;

  public AlunoController(AlunoRepository repository) {
    this.repository=repository;
  }

  @PostMapping("/cadastrarAluno")
  public void saveAluno(@RequestBody Aluno entity) {
    repository.save(entity);;
  }
}
