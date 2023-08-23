package com.appfusion.apigenerator.builder.repositories;

import com.appfusion.apigenerator.builder.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository<T extends Aluno, ID> extends JpaRepository<Aluno, ID> {
}
