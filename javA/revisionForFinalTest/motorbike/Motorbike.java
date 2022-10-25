package revisionForFinalTest.motorbike;

public class Motorbike {

    private String id;
    private String name;
    private String manu;
    private int quantity;
    private double price;
    private double weight;
    private String date;

    public Motorbike() {

    }

    public Motorbike(String id, String name, String manu, int quantity, double price, double weight, String date) {
        this.id = id;
        this.name = name;
        this.manu = manu;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void printMotorbike() {
        System.out.printf("%s %s %s %d %.1f %.1f %s", this.getId(), this.getName(), this.getManu(), this.getQuantity(), this.getPrice(), this.getWeight(), this.getDate());
    }
}
