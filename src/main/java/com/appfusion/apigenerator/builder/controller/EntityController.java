package com.appfusion.apigenerator.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appfusion.apigenerator.builder.entities.ModelEntity;
import com.appfusion.apigenerator.builder.resourceLoader.FolderHandler;
import com.appfusion.apigenerator.builder.service.EntityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * This class represents the controller for the Entity API endpoints.
 * It handles requests related to saving, creating, generating, publishing and
 * cleaning entities.
 * @author Gabriel Reis
 */
@RestController
@RequestMapping("/entity")
@Tag(name = "api-generator")
public class EntityController {

  @Autowired
  private EntityService service;

  public EntityController(EntityService service) {
    this.service = service;
  }

  @Operation(summary = "Save an entity")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/saveEntity")
  public ResponseEntity<ModelEntity> saveEntityReq(@RequestBody String entity) {
    return service.saveEntity(entity);
  }

  @Operation(summary = "Create an entity")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/createEntity/{id}")
  public void generateModelEntity(@PathVariable Long id) throws Exception {
    service.generateEntity(id);
  }

  @Operation(summary = "Generate a project")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/generateProject/{clientID}")
  public void generateProject(@PathVariable String clientID) throws Exception {
    FolderHandler.generateNewProject(clientID);
  }

  @Operation(summary = "Publish a project")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/publishProject/{clientID}")
  public void publishProject(@PathVariable String clientID) throws Exception {
    FolderHandler.publishProject(clientID);
  }

  @Operation(summary = "Clean a project content")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/cleanProjectContent")
  public void cleanProjectContent(@RequestBody String clientId) throws Exception {
    FolderHandler.cleanProjectContent(clientId);
  }
}
