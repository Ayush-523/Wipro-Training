package com.wipro.JavaBasics.GenericDataType;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Map.Entry;

public class Hash2{

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap();

		map.put(1, "java");
		map.put(2, "python");
		map.put(3, "C++");
		map.put(null, "react");

		for (Entry<Integer, String> obj : map.entrySet()) {
			System.out.print(obj.getKey() + " : ");
			System.out.println(obj.getValue() + "\n________________");
		}
	}
}