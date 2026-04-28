package com.wipro.JavaBasics.Abstraction;

public class InnerClass {

	public static void main(String[] args) {

		Calculation obj = new Calculation() {
			public void area(int side) {
				System.out.println("area of square " + (side * side));
			}
		};

		
		obj.area(3);
		
	}

}

interface Calculation {
	void area(int side);
}