package oopexercises.composition.book;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int quantity;

    public Book(String name, Author[] authors, double price, int quantity) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.quantity = quantity;
    }

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public String getAuthorInfos() {
        StringBuilder str = new StringBuilder();
        str.append("{ ");
        for (Author author : this.getAuthors()) {
            str.append(String.format("Author[ name = %s, email = %s, gender = %c ],", author.getName(), author.getEmail(), author.getGender()));
        }

        str.delete(str.length() - 1, str.length());
        str.append(" }");

        return str.toString();
    }

    public String getAuthorNames() {
        StringBuilder names = new StringBuilder();
        for (Author author : this.getAuthors()) {
            names.append(author.getName());
            names.append(" ,");
        }

        names.delete(names.length() - 2, names.length());
        return names.toString();
    }

    public String getAuthorEmails() {
        StringBuilder emails = new StringBuilder();
        for (Author author : this.getAuthors()) {
            emails.append(author.getEmail());
            emails.append(" ,");
        }

        emails.delete(emails.length() - 2, emails.length());
        return emails.toString();
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

    @Override
    public String toString() {
        return String.format("Book[name = %s, %s, price = %.2f, quantity = %d]", this.getName(), this.getAuthorInfos(), this.getPrice(), this.getQuantity());
    }
}
