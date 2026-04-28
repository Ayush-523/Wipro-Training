package com.wipro.JavaBasics.Methods;

public class MoreOps {

		public static void main(String[] args) {
		
			
			MoreOps obj=new MoreOps ();
			 int x=    obj.add(4,8);    // 12
		     int y =   obj.add(4, 9);   // 13
		                      // 12+ 13 = 25
		     
		  System.out.println("addition : "+obj.add(x, y));  //25
		     
		  System.out.println("square: "+obj.square(4));
		  System.out.println("cube : "+obj.cube(4));
		     
		}

		
		void display()
		{
	System.out.println("welcome");
		}
		
		int add(int x,int y)
		{ 
			return    x+y;
			
		}
		
		
		
		int square(int x)
		{
			return x*x;
		}
		
		int cube(int x)
		{
			return x*x*x;
		}

		
		
		String getMessage()
		{
			return "welcome to java programming";
		}
		
		
		
		
		
		
		
		
		
		
		
	}