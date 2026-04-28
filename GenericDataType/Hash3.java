package com.wipro.JavaBasics.GenericDataType;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Map.Entry;

public class Hash3{

	public static void main(String[] args) {

		Map<Integer, Learner> map = new HashMap();

		Learner l1 = null;
		map.put(1, l1);
		Learner l2 = null;
		map.put(2, l2);
		Learner l3 = null;
		map.put(3, l3);
		
		Learner l11 = new Learner();
		l11.setName("sakshi");

		Learner l21 = new Learner();
		l21.setName("Mohit");
		l21.setVideo("On");

		Learner l31 = new Learner();
		l31.setName("Priyanshi");
		l31.setVideo("On");
		l31.setMic("On");
		
		for (Entry<Integer, Learner> obj : map.entrySet()) {
			System.out.print(obj.getKey() + " : ");
			System.out.println(obj.getValue() + "\n________________");
		}
	}
}