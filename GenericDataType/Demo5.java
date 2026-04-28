package com.wipro.JavaBasics.GenericDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo5 {

	public static void main(String[] args) {
		
	
		List<String> list = new ArrayList<String>();
				
				list.add("java");
				list.add("c++");
				list.add("c");
				list.add("angular");
				list.add("javascript");
				list.add("jquery");
				list.add("python");
				list.add("c#");
				list.add("react");
                list.add("rust");
				
				list.stream()
				.filter(x -> x.startsWith("j"))
				.forEach(System.out::println);
				
		
		
		
	}
	}