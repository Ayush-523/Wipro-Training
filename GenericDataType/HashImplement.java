package com.wipro.JavaBasics.GenericDataType;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;

public class HashImplement {

	public static void main(String[] args) {
		
   Map<Integer,String>  setData=new HashMap();
   
   setData.put(1,"java");
   setData.put(2,"python");
   setData.put(3,"C++");   
   setData.put(null,"react");
 
   System.out.println(setData);

}}