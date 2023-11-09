package com.appfusion.apigenerator.builder.DTOs;

import com.appfusion.apigenerator.builder.templates.ControllerTemplate;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a data transfer object for an entity, containing its
 * JSON representation and a controller template.
 * 
 * @author Gabriel Reis
 */
@Data
@NoArgsConstructor
public class EntityDTO {

    private String json;
    private ControllerTemplate template;

    public EntityDTO(String json, ControllerTemplate template) {
        this.json = json;
        this.template = template;
    }
}
