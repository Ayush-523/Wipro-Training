package com.wipro.JavaBasics.ConsumerSupplier;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo {

	public static void main(String[] args) {
		
		Supplier<Student> s=new Supplier<Student>() {
		
			public Student get()
			{
				return  new Student("Sakshi","12"); // from database
			}
		};
		
		   System.out.println(s.get());


	}

}