package oops.student;

public class MasterStudent extends Student {

    private int noPublications;

    public MasterStudent() {
    }

    public MasterStudent(String id, String name, int age, String email, double gpa, int noPublications) {
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

        if (super.getGpa() < 3.2) {
            bonus = this.noPublications * 500000;
        }

        else if (super.getGpa()>=3.2 && super.getGpa()<3.6) {
            bonus = 1000000 + this.noPublications * 500000;
        }

        else {
            bonus = 2000000 + this.noPublications * 500000;
        }

        return bonus;
    }


    @Override
    public String toString() {
        return super.toString()+" MasterStudent [no_pub=" + this.noPublications + ", Bonus="
                + String.format("%.0f",this.getBonus()) + "]";
    }
}
