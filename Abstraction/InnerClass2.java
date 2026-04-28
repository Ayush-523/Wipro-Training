package com.wipro.JavaBasics.Abstraction;




public class InnerClass2 {

	public static void main(String[] args) {
		   Outer out=new Outer();
		   Inner in= out.new Inner();
		     in.display();
		   
		     
		     
		     Outer.Innerstatic  obj=new Outer.Innerstatic();
		     obj.check();
	}

}


class Outer  // outer
{
	
	int version=20;
	
	
	class Inner //inner
	{
		int x=30;
		void display()
		{
			System.out.println(version);
			class MethodInner
			{
				void show()
				{
					System.out.println("method inner class working!");
				}
			}
			
			MethodInner obj=new MethodInner();
			obj.show();
			
			
		}
	}
	
	
	static class Innerstatic
	{
		void check()
		{
			System.out.println("check for inner sttaic class working!");
		}
	}
	
	
}