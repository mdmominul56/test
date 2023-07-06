/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.management.system.model;

/**
 *
 * CREATE TABLE "HR"."INFO" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(255 BYTE), 
	"MOBILENUMBER" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(255 BYTE), 
	"GENDER" VARCHAR2(10 BYTE), 
	"FATHERNAME" VARCHAR2(255 BYTE), 
	"MOTHERNAME" VARCHAR2(255 BYTE), 
	"GYMTIME" VARCHAR2(20 BYTE), 
	"ADHARNUMBER" VARCHAR2(20 BYTE), 
	"AGE" VARCHAR2(10 BYTE), 
	"AMOUNT" VARCHAR2(10 BYTE)
   );
 * 
 * 
 * @author CGNT
 */
public class Member {
    
  public int id;
  public  String name;
  public String mobileNumber;
  public String email;
  public String gender;
  public String fatherName;
  public String motherName;
  public String gymTime;
  public String nid;
  public String  age;
  public String amount;
           
}
