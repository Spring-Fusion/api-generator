package com.appfusion.apigenerator.builder.codegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.Packages;
import com.appfusion.apigenerator.builder.resourceLoader.FolderHandler;
import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.RepositoryTemplate;
import com.squareup.javapoet.TypeSpec;

/**
 * This class generates a repository based on a JSON input using a default
 * template.
 * The generated repository is saved as a Java file in the specified package.
 * 
 * © Spring Fusion 2023
 * 
 * @author Gabriel Reis
 */
public class RepositoryGenerator {

  private static Logger LOG = LoggerFactory.getLogger(RepositoryGenerator.class);

  /**
   * Generates a repository based on the provided JSON.
   *
   * @param json the JSON data used to generate the repository
   * @throws Exception if an error occurs during the generation process
   */
  public static void generateRepository(String json) {
    try {
      RepositoryTemplate repositoryTemplate = RepositoryTemplate.getDefaultTemplate(json);
      TypeSpec spec = RepositoryTemplate.getRepositoryTypeSpec(json, repositoryTemplate);
      JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Repositories.value, spec,
      EntityUtil.getJsonValue(json, "clientID"));
      FolderHandler.saveJavaFile(fileDTO);
      LOG.info("Repository generated successfully");
    } catch (Exception e) {
      LOG.error("Error generating repository: " + e.getMessage());
    }
  }

}
