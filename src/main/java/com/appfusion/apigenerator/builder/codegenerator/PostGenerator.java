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

  public void generatePostEntity(String json) {
    JSONObject jsonObject = new JSONObject(util.getEntityFromJson(json)); 
  }
  
  public void setClassFields(DynamicType.Unloaded<?> generatedClass) {
   generatedClass = new ByteBuddy()
       .redefine(PostTemplate.class)
       .name("builder.generatedClasses.Test")
       .defineField("nome", String.class, Visibility.PRIVATE)
       .make();
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
