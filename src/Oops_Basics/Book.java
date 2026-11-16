package Oops_Basics;

public class Book {

    String title;
    String author;
    double price;

    // 1. Default / No-Argument Constructor
    // Runs when you call: new Book()
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    // 2. Parameterized Constructor (Constructor Overloading)
    // Runs when you pass values: new Book("Clean Code", "Robert Martin", 499.0)
    public Book(String title, String author, double price) {
        // 'this.title' refers to the class's instance variable.
        // 'title' (on the right) refers to the parameter passed into the constructor.
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("Book: '" + title + "' by " + author + " - Rs. " + price);
    }
}
