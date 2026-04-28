package com.wipro.JavaBasics.Inheritence;

public class Iphone12 extends Iphone11{
	
//	int version = 23;
	
	void features() {
		System.out.println("features from iphone 12 class");
	}
}


class Iphone13  extends Iphone12{

	int version=22;
	
	void extrafeatures()
	{
		int version=20;
		System.out.println(super.version); //23
		System.out.println(this.version );
		System.out.println(version );
	}
}