package oopexercises.classesandobjects.invoiceitem;

public class InvoiceItem {
    private String id;
    private String description;
    private int quantity;
    private double unitPrice;

    public InvoiceItem(String id, String description, int quantity, double unitPrice) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return this.getQuantity() * this.getUnitPrice();
    }

    @Override
    public String toString() {
        return String.format("Invoice[id = %s, description = %s, quantity = %d, unit price = %.2f]", this.getId(), this.getDescription(), this.getQuantity(), this.getUnitPrice());
    }
}
