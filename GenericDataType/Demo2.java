package com.wipro.JavaBasics.GenericDataType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {

		List<String> emplist = new ArrayList<String>();

		emplist.add("Aakshi");
		emplist.add("Neha");
		emplist.add("Rohit");
		emplist.add("Akash");

		for (String element : emplist) {
			if (element.startsWith("A"))
				System.out.println(element);
		}

		List<Integer> emplist2 = new ArrayList<Integer>();

		emplist2.add(23);
		emplist2.add(45);
		emplist2.add(33);
		for (int element : emplist2) {

			System.out.println(element);
		}

	}
}