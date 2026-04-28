package com.wipro.JavaBasics.Abstraction;

abstract class TV{
    
    abstract void turnOn();
    abstract void turnOff();
}

// Concrete class implementing the abstract methods
class TVRemote extends TV{
    
    @Override
    void turnOn(){
        
        System.out.println("TV is turned ON.");
    }

    @Override
    void turnOff(){
        
        System.out.println("TV is turned OFF.");
    }
}

// Main class to demonstrate abstraction
public class RemoteFeatures{
    
    public static void main(String[] args){
        
        TV remote = new TVRemote();
        remote.turnOn();   
        remote.turnOff();  
    }
}