package revisionForFinalTest.computer;

public class Computer {

    private String name;
    private String manu;
    private int year;
    private String detail;
    private Double price;

    public Computer() {

    }

    public Computer(String name, String manu, int year, String detail, Double price) {
        this.name = name;
        this.manu = manu;
        this.year = year;
        this.detail = detail;
        this.price = price;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s %.1f", this.getName(), this.getManu(), this.getYear(), this.getDetail(), this.getPrice());
    }
}
