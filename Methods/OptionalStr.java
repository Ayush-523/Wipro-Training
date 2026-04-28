package com.wipro.JavaBasics.Methods;

import java.util.Optional;

public class OptionalStr {

	public static void main(String[] args) {
		String name = null;
		
		Optional<String> object = Optional.ofNullable(name);
		
		if (object.isPresent())
			System.out.println(name.charAt(2));
		else
			System.out.println("name is empty!");
	}

}
