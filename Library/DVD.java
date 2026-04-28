package com.wipro.JavaBasics.Library;

class DVD extends LibraryItem {
    int duration; // in minutes

    DVD(String title, String author, int itemId, int duration) {
        super(title, author, itemId);
        this.duration = duration;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Duration: " + duration + " mins");
    }
}