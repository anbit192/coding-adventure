package oopexercises.composition.book;

public class TestMain {
    public static void main(String[] args) {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        Author anbish = new Author("anbish","nguyenminhan_t66@hus.edu.vn", 'm');
        System.out.println(ahTeck);  // Author's toString()
        System.out.println(anbish);

        Book dummyBook = new Book("Java for dummy", new Author[]{ahTeck,anbish}, 19.95, 99);  // Test Book's Constructor
        System.out.println(dummyBook);  // Test Book's toString()

// Test Getters and Setters
        dummyBook.setPrice(29.95);
        dummyBook.setQuantity(28);
        System.out.println("name is: " + dummyBook.getName());
        System.out.println("price is: " + dummyBook.getPrice());
        System.out.println("qty is: " + dummyBook.getQuantity());
        System.out.println("Authors are: " + dummyBook.getAuthorInfos());
        System.out.println("Authors's name are: " + dummyBook.getAuthorNames());
        System.out.println("Authors's email are: " + dummyBook.getAuthorEmails());

    }
}
