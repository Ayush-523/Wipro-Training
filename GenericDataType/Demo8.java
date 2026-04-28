package com.wipro.JavaBasics.GenericDataType;


public class Demo8 {

	public static void main(String[] args) {
		
		List<Student> students=new ArrayList<Student>();
		  Student s1=new Student("Sakshi",12);
	      Student s2=new Student("Ram",22);
	      Student s3=new Student("Sakshi",12);
	      Student s4=new Student("Sneha",14);
	      
	      
	      students.add(s1);
	      students.add(s2);
	      students.add(s3);
	      students.add(s4);

	
	         students.stream()
	         .filter(x ->    x.getName().contains("S") )
	         .map(x -> x.getName().toUpperCase())
	         .forEach(System.out::println);

	}
}