package com.wipro.JavaBasics.Inheritence;

public class Mobile {
    public static void main(String[] args) {

        Android obj = new Android();
        obj.camera();

        Iphone obj2 = new Iphone();
        obj2.camera();
    }
}

// Parent class
class Mobilef {
    void camera() {
        System.out.println("basic camera");
    }
}

// Child class Android
class Android extends Mobile {
    void camera() {
        System.out.println("android camera");
    }
}

// Child class Iphone
class Iphone extends Mobile {
    void camera() {
        System.out.println("iphone camera");
    }
}