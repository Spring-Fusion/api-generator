package com.appfusion.apigenerator.builder.enums;

/**
 * This enum represents the Jakarta packages used in the application.
 * 
 * @author Gabriel Reis
 */
public enum JakartaPackges {
  
  Entity("Entity"),
  Id("Id"),
  GeneratedValue("GeneratedValue"),
  GenerationType("GenerationType"),
  Column("Column"),
  Table("Table");

  public String value;

  private JakartaPackges(String value){
    this.value = value;
  }

}
