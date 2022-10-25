package oopexercises.composition.mybooks;

public class Book {
    private String isbn;
    private String name;
    private Author author;
    private double price;
    private int quantity;

    public Book(String isbn, String name, Author author, double price) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = 0;
    }

    public Book(String isbn, String name, Author author, double price, int quantity) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthorName() {
        return this.getAuthor().getName();
    }

    @Override
    public String toString() {
        return String.format("isbn = %s, name = %s, %s, price = %.2f, quantity = %d", this.getIsbn(), this.getName(), this.getAuthor().toString(), this.getPrice(),this.getQuantity());
    }

}
