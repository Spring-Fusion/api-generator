package com.appfusion.apigenerator.builder.service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class EntityUtilTest {

  EntityUtil entityUtil = new EntityUtil();

  @Test
  void getEntityFromJsonSucces() throws Exception {
    String expectedValue = "{\"name\":\"varchar(255)\"}";
    assertEquals(expectedValue, entityUtil.getEntityFromJson(getJson()));
  }

  public String getJson() throws Exception {
    Path path = Path.of("C:/Test Files/fileTest.json");
    String json = Files.readString(path);
    return json;
  }

}
