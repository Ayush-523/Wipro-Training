package com.wipro.JavaBasics.ConsumerSupplier;



public class Student {

	String name,rollno;

	public Student(String name, String rollno) {
		super();
		this.name = name;
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + "]";
	}
	
}