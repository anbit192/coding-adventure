package oops.candidate;

public class Candidate {

    private String id;
    private String name;
    private String selection;
    private String sex;
    private int year;
    private int priority;

    public Candidate(String id, String name, String selection, String sex, int year, int priority) {
        this.id = id;
        this.name = name;
        this.selection = selection;
        this.sex = sex;
        this.year = year;
        this.priority = priority;
    }

    public Candidate() {

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

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return id + " " + this.name + " " + this.selection + " " + this.sex + " " + this.year + " " + this.priority;
    }

    public void printInfo() {
        System.out.println(this.toString());
    }
}
