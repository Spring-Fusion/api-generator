package com.appfusion.apigenerator.builder.enums;

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
