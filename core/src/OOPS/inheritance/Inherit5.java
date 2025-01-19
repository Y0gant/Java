package src.OOPS.inheritance;

/**
 * Create two interfaces Printable and Readable.
 * Add a method print() in Printable and read() in Readable.
 * Create a class Book that implements both interfaces and call both methods.
 */
interface Printable {
    void print();
}

interface Readable {
    void read();
}

class Book implements Printable, Readable {
    String title;
    String author;
    String publisher;
    int pages;
    double price;

    Book(String title, String author, String publisher, int pages, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.println("Printing book details :");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Pages: " + pages);
        System.out.println("Price: " + price);

    }

    @Override
    public void read() {
        System.out.println("Reading " + title + " by " + author + "...");
    }
}

public class Inherit5 {
    public static void main(String[] args) {
        Book b1 = new Book("Head First Java: A Brain-Friendly Guide, 2Nd Edition", "Kathy Sierra & Bert Bates ", "O'Reiley", 742, 1850.00);
        b1.print();
        b1.read();
    }
}
