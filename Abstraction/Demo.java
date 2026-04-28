package com.wipro.JavaBasics.Abstraction;


public class Demo {

	public static void main(String[] args) {
		Mobile m=new Android();
		Phone p=new Android();
	}
}



interface Soemthing 
{   
void calling();  // abstract - which doesnot have body
}

interface Phone 
{   
void calling();  // abstract - which doesnot have body
}


interface Mobile extends Phone, Soemthing
{
void camera();    // abstract - which doesnot have body
}




class Android implements Mobile
{

	public void camera() {
		System.out.println("android camera");
	}

	public void calling() {
		System.out.println("iphone calling");
	}
	
}



class Iphone extends App implements Mobile,Phone 
{

	public void camera() {
		System.out.println("iphone camera");
	}

	public void calling() {
		System.out.println("iphonecalling");
		
	}

	
}














abstract class App 
{
	
	public abstract void show(); // abstract functions
	
	
	
	void display()
	{
		System.out.println("non- abstract fucntion");
	}
}




class Ch extends App
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}













class Contact 
{
	
	
	
	
	void fetchListOfContacts()
	{
		
	List obj	 = db.getData();
	}
	
	
	
}





// List -->     ArrayList , LinkedList , other form