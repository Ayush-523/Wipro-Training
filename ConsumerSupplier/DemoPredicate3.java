package com.wipro.JavaBasics.ConsumerSupplier;

import java.util.function.Function;
import java.util.function.Predicate;


public class DemoPredicate3 {

	public static void main(String[] args) {
		   
	Function<Integer,String> func=new Function<Integer, String>() {
		
		   public  String apply(Integer input)
		   {
			   if(input%2==0)
				   return input+" is even ";
			   else
			   return input+" is odd";
		   }
		
	};
	
		System.out.println(func.apply(4));

	}

}