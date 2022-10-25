package revisionForFinalTest.baby;

public class Baby {

    private String day;
    private String name;
    private boolean gender;
    private double weight;
    private double height;

    public Baby() {
        this.day = "01/01/2020";
        this.name = "Unregistered";
    }

    public Baby(String name, String day, boolean gender, double weight, double height) {
        this.day = day;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        if (this.gender) {
            return "Girl";
        }

        return "Boy";
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getDay() + " " + this.getGender() + " " + this.getHeight()+ " " + this.getWeight();
    }
}
