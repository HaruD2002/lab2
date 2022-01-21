/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.math.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;
/**
 *
 * @author Admin
 */
public class Student {
    int id;
    String Name;
    Boolean Gender; 
    Date DOB; 

    public Student() {
    }

    public Student(int id, String Name, Boolean Gender, Date DOB) {
        this.id = id;
        this.Name = Name;
        this.Gender = Gender;
        this.DOB = DOB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    public static String gName(){
         //65 90
         // 97 122
         String myString = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
         Random number = new Random();
         
         int Stringlength = number.nextInt(10)+1;
         
         String newString = "";
         for (int i = 0; i <= Stringlength; i++) {
            int index = number.nextInt(myString.length());
            newString = newString + myString.charAt(index);
        }
         return newString;
    }
    
    public static boolean gGender(){
        return new Random().nextBoolean();        
    }
    
    public static Date gDOB() throws ParseException{
        Random r = new Random();       
        int a = r.nextInt(36500);
        String c = LocalDate.now().minusDays(a).toString();
        Date aa = new SimpleDateFormat("yyyy-MM-dd").parse(c);
        return aa;
    }
    
    
    public String fixedDate(){
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            
            return simpleDateFormat.format(DOB);
    }   
    
    public static ArrayList<Student> generate(int ids) throws ParseException{
        ArrayList<Student> contain = new ArrayList<>(); 
        for (int i = 1; i <= ids; i++) {
            contain.add(new Student(i,gName(),gGender(),gDOB()));    
        }
        return contain;
    }
}
