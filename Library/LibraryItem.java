package com.wipro.JavaBasics.Library;
class LibraryItem {
    String title;
    String author;
    int itemId;

    // Constructor
    LibraryItem(String title, String author, int itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
    }

    // Method to display common info
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Item ID: " + itemId);
    }
}