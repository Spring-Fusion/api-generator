package com.appfusion.apigenerator.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appfusion.apigenerator.builder.entities.PostEntity;
import com.appfusion.apigenerator.builder.resourceLoader.ResourceLoader;
import com.appfusion.apigenerator.builder.service.PostEntityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/entity")
@Tag(name = "api-generator")
public class EntityController {

  @Autowired
  private PostEntityService service;

  public EntityController(PostEntityService service) {
    this.service = service;
  }

  @Operation(summary = "Save an entity")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/saveEntity")
  public ResponseEntity<PostEntity> saveEntityReq(@RequestBody String entity) {
    return service.saveEntity(entity);
  }

  @Operation(summary = "Create an entity")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/createEntity/{id}")
  public void generatePostEntity(@PathVariable Long id) throws Exception {
    service.generateEntity(id);
  }

  @Operation(summary = "Generate a project")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/generateProject")
  public void generateProject(@RequestBody String clientId) throws Exception {
    ResourceLoader.generateNewProject(clientId);
  }

  @Operation(summary = "Publish a project")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/publishProject")
  public void publishProject(@RequestBody String clientId) throws Exception{
    ResourceLoader.publishProject(clientId);
  }

  @Operation(summary = "Clean a project content")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "success")
  })
  @PostMapping("/cleanProjectContent")
  public void cleanProjectContent(@RequestBody String clientId) throws Exception{
    ResourceLoader.cleanProjectContent(clientId);
  }
}
