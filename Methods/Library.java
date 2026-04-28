package com.wipro.JavaBasics.Methods;

class Book {
    String title;
    String author;
    boolean isIssued;

    // Constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println(title + " issued.");
        } else {
            System.out.println(title + " is already issued.");
        }
    }

    void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println(title + " returned.");
        } else {
            System.out.println(title + " was not issued.");
        }
    }

    void displayStatus() {
        System.out.println(title + " by " + author + " | Issued: " + isIssued);
    }
}

public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "Author A");

        b1.displayStatus();
        b1.issueBook();
        b1.displayStatus();
        b1.returnBook();
        b1.displayStatus();
    }
}