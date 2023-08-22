package com.appfusion.apigenerator.builder.codegenerator;

import java.io.File;
import java.util.Map;

import org.json.JSONObject;

import com.appfusion.apigenerator.builder.service.util.EntityUtil;
import com.appfusion.apigenerator.builder.templates.PostTemplate;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;

public class PostGenerator {

  EntityUtil util = new EntityUtil();

  public void generatePostEntity(String json) throws Exception {
    JSONObject jsonObject = new JSONObject(util.getEntityFromJson(json));
    Object entityName = util.getEntityNameFromJson(new JSONObject(json));
    System.out.println(entityName);
    System.out.println(util.getEntityFields(jsonObject));
    setBuildClass(util.getEntityFields(jsonObject), entityName.toString());
    
  }
  
  public void setBuildClass(Map<Object, Object> fields, String entityName) throws Exception {
    DynamicType.Builder<?>
   generatedClass = new ByteBuddy()
       .redefine(PostTemplate.class)
       .name("com.appfusion.apigenerator.builder.entities."+entityName);
       
    for(Object field: fields.keySet()) {
      generatedClass = generatedClass.defineField(field.toString(), String.class, Visibility.PRIVATE);
    }
    
    DynamicType.Unloaded<?> loadedClass = generatedClass.make();
    
    loadedClass.saveIn(new File("C:/Users/gabriel.reis/Desktop/API - Genrator/api-generator/target/classes/"));
    
  }
  
  public Map<Object, Object> getFields(JSONObject jsonObject){
    return util.getEntityFields(jsonObject); 
  }
  
  public static void test() throws Exception {
    DynamicType.Unloaded<?> dynamicType = new ByteBuddy().redefine(PostTemplate.class).name("example.Test")
        .defineField("nome", String.class, Visibility.PRIVATE).make();

    dynamicType.saveIn(new File("C:\\Teste"));
  }

  public static void main(String[] args) throws Exception {
    test();
  }
  
}
