package com.wipro.JavaBasics.LambdaExpression;

public class Demo3 {

	public static void main(String[] args) {
		
		
Shape2 square= (x,y) ->  (x*y)  ;
	
		System.out.println("Area of rectangle: "+square.area(4,5));
		
	}
	
}


interface Shape2
{
	int area(int x,int y);
}