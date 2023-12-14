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
  Table("Table"),
  ManyToOne("ManyToOne"),
  ManyToMany("ManyToMany"),
  OneToMany("OneToMany"),
  OneToOne("OneToOne");

  public String value;

  private JakartaPackges(String value){
    this.value = value;
  }

}
