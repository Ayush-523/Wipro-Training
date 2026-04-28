package com.wipro.JavaBasics.ConsumerSupplier;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Demo3 {

	public static void main(String[] args) {
	
		
		Consumer<Student> cons=new Consumer<Student>() {

			public void accept(Student t) {
				System.out.println(t);
				
			}
			
		};

		cons.accept(new Student("Sakshi","123"));
		
		Supplier<Student> supp=new Supplier<Student>()
				{

					public Student get() {
					return new Student("Sakshi","123");
					}
			
				};
		
		
		 System.out.println(supp.get());
		
		
		Predicate<String>  pred=new Predicate<String>()
				{

					public boolean test(String t) {
						
						if(t.startsWith("s"))  
						return true;
						else
						return false;
					}
			
			
				};
		
	System.out.println(pred.test("sakshi"));
		
		
		
	Function<Integer,String> func=new Function<Integer, String>() {
		
		   public  String apply(Integer input)
		   {
			   int result=input*input;
			   return "square of a number :"+result;
		   }
		
	};
	
		System.out.println(func.apply(4));

	}

}