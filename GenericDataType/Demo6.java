package com.wipro.JavaBasics.GenericDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo6 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		list.add(3000);
		list.add(4000);
		list.add(8000);
		list.add(9000);
		list.add(9000);
		list.add(2000);
		list.add(10000);
		list.add(12000);
		list.add(2000);
		list.add(2500);

		long result = list.stream()
				          .map(x -> x + 500)
				          .filter(x -> x > 3000)
				          .count();

		System.out.println(result);

	}
}