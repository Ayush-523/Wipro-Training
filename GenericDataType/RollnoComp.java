package com.wipro.JavaBasics.GenericDataType;

import java.util.Comparator;

public class RollnoComp implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getRollno() < o2.getRollno())
			return -1;
		else if (o1.getRollno() == o2.getRollno())
			return 0;
		else
			return 1;
	}

}

class NameComp implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}