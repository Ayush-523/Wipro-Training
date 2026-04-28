package com.wipro.JavaBasics.Methods;

public class Addition1 {

	public static void main(String[] args) {

		Addition1 obj = new Addition1();
		int x = obj.add(4, 8); // 12
		int y = obj.add(4, 9); // 13
		// 12+ 13 = 25

		System.out.println("addition : " + obj.add(x, y)); // 25

		System.out.println("square: " + obj.square(4));
		System.out.println("cube : " + obj.cube(4));

	}

	void display() {
		System.out.println("welcome");
	}

	public int add(int x, int y) {
		return x + y;

	}

	public int square(int x) {
		return x * x;
	}

	int cube(int x) {
		return x * x * x;
	}

	public String getName(String name)
	{
		return  name;
	}
	
	 public void throwException() throws Myexception {
	        throw new Myexception("This is Custom exception message");
	 }
}