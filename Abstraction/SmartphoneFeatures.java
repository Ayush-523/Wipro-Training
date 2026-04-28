package com.wipro.JavaBasics.Abstraction;

interface Camera {
 void takePhoto();
}

interface MusicPlayer {
 void playMusic();
}

class SmartPhone implements Camera, MusicPlayer {

 public void takePhoto() {
     System.out.println("Taking photo...");
 }

 public void playMusic() {
     System.out.println("Playing music...");
 }
}

public class SmartphoneFeatures {
 public static void main(String[] args) {
     SmartPhone phone = new SmartPhone();

     phone.takePhoto();
     phone.playMusic();
 }
}