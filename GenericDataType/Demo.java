package com.wipro.JavaBasics.GenericDataType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		List<String> emplist = new ArrayList<String>();

		emplist.add("sakshi");
		emplist.add("Neha");
		emplist.add("Rohit");

		System.out.println(emplist);

		List list = new ArrayList(); // Object
		list.add(234);
		list.add("sakshi");
		list.add(true);
		list.add(34.5f);
		
		System.out.println(list);

	}
}