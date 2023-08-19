package com.appfusion.apigenerator.builder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appfusion.apigenerator.builder.entities.PostEntity;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {

}
