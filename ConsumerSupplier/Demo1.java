package com.wipro.JavaBasics.ConsumerSupplier;

import java.util.function.Consumer;

public class Demo1 {

	public static void main(String[] args) {
		
		
		Consumer<String>   consum= new Consumer<String>() {
			
			
			public void accept(String x)
			{
				System.out.println(x);
			}
			
		};
		
		
		
		consum.accept("welcome message");

	}

}