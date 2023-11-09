package com.appfusion.apigenerator.builder.codegenerator;

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
 * @author Gabriel Reis
 */
public class RepositoryGenerator {

  public static void generateRepository(String json) throws Exception {
    RepositoryTemplate repositoryTemplate = RepositoryTemplate.getDefaultTemplate(json);
    TypeSpec spec = RepositoryTemplate.getRepositoryTypeSpec(json, repositoryTemplate);
    JavaFileDTO fileDTO = new JavaFileDTO(EntityUtil.getJsonValue(json, "package") + Packages.Repositories.value, spec,
    EntityUtil.getJsonValue(json, "clientID"));
    FolderHandler.saveJavaFile(fileDTO);
  }

}
