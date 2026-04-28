package com.wipro.JavaBasics.Library;

public class Main {
    public static void main(String[] args) {

        Book b = new Book("Java Basics", "Author A", 101, 300);
        Magazine m = new Magazine("Tech Monthly", "Author B", 102, 45);
        DVD d = new DVD("Learning Java", "Author C", 103, 120);

        System.out.println("Book Details:");
        b.displayInfo();

        System.out.println("\nMagazine Details:");
        m.displayInfo();

        System.out.println("\nDVD Details:");
        d.displayInfo();
    }
}