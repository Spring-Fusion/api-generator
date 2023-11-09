package com.appfusion.apigenerator.builder.entityContent;

import com.appfusion.apigenerator.builder.enums.SpringClasses;
import com.appfusion.apigenerator.builder.enums.SpringPackages;
import com.appfusion.apigenerator.builder.interfaces.EntityContent;
import com.squareup.javapoet.ClassName;

/**
 * This class represents the implementation of the EntityContent interface for
 * PathVariable class name.
 * 
 * @author Gabriel Reis
 */
public class PathVariebleClassName implements EntityContent {

    @Override
    public ClassName getContent() {
        return ClassName.get(SpringPackages.WebBind.value, SpringClasses.PathVariable.value);
    }

}
