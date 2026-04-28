package com.wipro.JavaBasics.ConsumerSupplier;


import java.util.function.Consumer;

public class Demo2 {

	public static void main(String[] args) {
		
		
		Consumer<Student>   consum= new Consumer<Student>() {
			
			
			public void accept(Student x)
			{
				System.out.println(x);
			}
			
		};
		
		
		Student obj=new Student("Sakshi","12");
		consum.accept(obj);

	}

}