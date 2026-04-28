package com.wipro.JavaBasics.ConsumerSupplier;


import java.util.function.Function;
import java.util.function.Predicate;


public class DemoPredicate2 {

	public static void main(String[] args) {
		   
	Function<Integer,Integer> func=new Function<Integer, Integer>() {
		
		   public  Integer apply(Integer input)
		   {
			   
			   int result= input*input*input;
			   return result;
		   }
		
	};
	
		System.out.println(func.apply(3));

	}

}