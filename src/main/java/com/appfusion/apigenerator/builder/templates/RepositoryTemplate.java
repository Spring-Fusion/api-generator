package com.appfusion.apigenerator.builder.templates;

import javax.lang.model.element.Modifier;

import com.appfusion.apigenerator.builder.entityContent.JpaRepositoryClassName;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import lombok.Data;

/**
 * This class represents a template for generating a repository interface.
 * It contains the necessary information to generate a repository interface
 * using the TypeSpec class from the JavaPoet library.
 * 
 * @author Gabriel Reis
 */
@Data
public class RepositoryTemplate {

  private ClassName jpaRepositoryClass;
  private ClassName entityType;

  public RepositoryTemplate(ClassName jpaRepositoryClass, ClassName entityType) {
    this.jpaRepositoryClass = jpaRepositoryClass;
    this.entityType = entityType;
  }

  public static RepositoryTemplate getDefaultTemplate(String json) {
    return new RepositoryTemplate(
        new JpaRepositoryClassName().getContent(),
        new JpaRepositoryClassName().getPackgeContent(json));
  }

  public static TypeSpec getRepositoryTypeSpec(String json, RepositoryTemplate repositoryTemplate) {
    return TypeSpec
        .interfaceBuilder(EntityUtil.getJsonValue(json, "entityName") + "Repository")
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(
            ParameterizedTypeName.get(repositoryTemplate.getJpaRepositoryClass(),
                repositoryTemplate.getEntityType(),
                TypeVariableName.get("Long")))
        .build();
  }

}
