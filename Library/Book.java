package com.wipro.JavaBasics.Library;
class Book extends LibraryItem {
    int pages;

    Book(String title, String author, int itemId, int pages) {
        super(title, author, itemId);
        this.pages = pages;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Pages: " + pages);
    }
}