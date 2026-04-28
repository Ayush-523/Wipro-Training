package com.wipro.JavaBasics.LambdaExpression;

public class Demo1 {

	public static void main(String[] args) {
		
		
Shape1 square= (x,y) ->
                 {  System.out.println("area of rectangle:"+(x*y));
                       System.out.println("Thankyou!");
                        };
	
		square.area(4,5);
		
	}
	
}


interface Shape1
{
	void area(int x,int y);
}