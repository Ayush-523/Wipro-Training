package com.wipro.JavaBasics.GenericDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;   // step1

import com.wipro.JavaBasics.Inheritence.Main;


public class App2 extends Main
{
    public static void main( String args[] )
    {
    	
      Student s1=new Student("Sakshi",12);
      Student s2=new Student("Ram",22);
      Student s3=new Student("Neha",13);
      Student s4=new Student("Sneha",14);
      
      List<Student> list=new ArrayList<Student>();
      list.add(s1);
      list.add(s2);
      list.add(s3);
      list.add(s4);
      
      Collections.sort(list);
      for(Student s:list)
      System.out.println(s.getName());
    }


}