package com.wipro.JavaBasics.Library;
class Magazine extends LibraryItem {
    int issueNumber;

    Magazine(String title, String author, int itemId, int issueNumber) {
        super(title, author, itemId);
        this.issueNumber = issueNumber;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Number: " + issueNumber);
    }
}
