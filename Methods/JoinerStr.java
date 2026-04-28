package com.wipro.JavaBasics.Methods;

import java.util.StringJoiner;


public class JoinerStr {

	public static void main(String[] args) {
		   StringJoiner sj = new StringJoiner("- ", "{","}");

	        // Add strings which you need to join
	        sj.add("geeks").add("for").add("geeks");

	        System.out.println("Joined String: " + sj);
	}

}