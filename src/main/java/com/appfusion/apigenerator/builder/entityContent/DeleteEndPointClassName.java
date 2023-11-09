package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * This class represents the implementation of the EntityContent interface for
 * generating the class name of a Spring Boot DELETE endpoint.
 * 
 * @author Gabriel Reis
 */
public class DeleteEndPointClassName implements EntityContent {

    @Override
    public ClassName getContent() {
        return ClassName.get(SpringPackages.WebBind.value, SpringClasses.DeleteMapping.value);
    }

}
