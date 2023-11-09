package com.appfusion.apigenerator.builder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appfusion.apigenerator.builder.entities.ModelEntity;

public interface EntityRepository extends JpaRepository<ModelEntity, Long> {

}
