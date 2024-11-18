package ie.atu.serialization;

import java.io.Serializable;

public class Book implements Serializable{
    private String title;
    private String author;
    private double price;
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + 
               author + "', price=" + price + "}";
    }
}
