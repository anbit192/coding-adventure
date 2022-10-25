package oops.student;

public class PhDStudent extends Student {
    private int noPublications;

    public PhDStudent() {

    }

    public PhDStudent(String id, String name, int age, String email, double gpa, int noPublications) {
        super(id, name, age, email, gpa);
        this.noPublications = noPublications;
    }

    public int getNoPublications() {
        return noPublications;
    }

    public void setNoPublications(int noPublications) {
        this.noPublications = noPublications;
    }

    @Override
    public double getBonus() {

        double bonus;

        if (super.getFaculty().equals("Natural Science")) {
            bonus = this.noPublications * 2000000;
        }

        else {
            bonus = this.noPublications * 3000000;
        }

        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " PhDStudent [no_pub=" + this.noPublications + ", Bonus()="
                + String.format("%.0f", this.getBonus()) + "]";
    }
}
