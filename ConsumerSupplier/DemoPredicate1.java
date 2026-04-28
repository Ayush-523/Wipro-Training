package com.wipro.JavaBasics.ConsumerSupplier;

import java.util.function.Predicate;

public class DemoPredicate1 {

	public static void main(String[] args) {
		   
		
		Predicate<Integer> pred= new Predicate<Integer>() {
		
		       public boolean test(Integer x)
		       {
		           return x>18;
		       }
		   };
		   System.out.println(pred.test(3));


	}

}