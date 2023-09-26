package com.appfusion.apigenerator.builder.service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EntityUtilTest {

  private String json = "{\r\n"
      + "    \"entity\":{\r\n"
      + "        \"name\":{\r\n"
      + "            \"type\":\"string\",\r\n"
      + "            \"size\":\"60\"\r\n"
      + "        },\r\n"
      + "        \"age\":{\r\n"
      + "            \"type\":\"int\",\r\n"
      + "            \"size\":\"3\"\r\n"
      + "        },\r\n"
      + "        \"email\":{\r\n"
      + "            \"type\":\"string\",\r\n"
      + "            \"size\":\"100\"\r\n"
      + "        },\r\n"
      + "        \"salary\":{\r\n"
      + "            \"type\":\"double\"\r\n"
      + "        },\r\n"
      + "        \"children\":{\r\n"
      + "            \"type\":\"boolean\"\r\n"
      + "        },\r\n"
      + "        \"eventDateTime\":{\r\n"
      + "            \"type\":\"localDateTime\"\r\n"
      + "        },\r\n"
      + "        \"time\":{\r\n"
      + "            \"type\":\"instant\"\r\n"
      + "        }\r\n"
      + "    },\r\n"
      + "    \"entityName\":\"Employee\",\r\n"
      + "    \"endPointName\":\"employee\",\r\n"
      + "    \"package\":\"com.appfusion.apigenerator.builder\",\r\n"
      + "    \"modifier\":\"public\",\r\n"
      + "    \"clientID\":\"gabriel1234\"\r\n"
      + "}\r\n"
      + "";
  
  @Test
  void getJsonValueType() {
    String result = EntityUtil.getJsonValue(this.json, "package");
    assertEquals("com.appfusion.apigenerator.builder", result);
  }
  
  @Test
  void getJsonclientID() {
    String result = EntityUtil.getJsonValue(this.json, "clientID");
    assertEquals("gabriel1234", result);
  }
  
  @Test
  void getJsonModifier() {
    String result = EntityUtil.getJsonValue(this.json, "modifier");
    assertEquals("public", result);
  }
  
  @Test
  void getJsonEntityName() {
    String result = EntityUtil.getJsonValue(this.json, "endPointName");
    assertEquals("employee", result);
  }
  
  @Test
  void getJsonEndPointName() {
    String result = EntityUtil.getJsonValue(this.json, "entityName");
    assertEquals("Employee", result);
  }

}
