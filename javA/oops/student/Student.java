package oops.student;

public class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private double gpa;

    public Student() {

    }

    public Student(String id, String name, int age, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getBonus() {
        return 0;
    }


    public String getFaculty() {

        String temp = "";
        int startIndex = this.getEmail().indexOf("@")+1;
        int endIndex = this.getEmail().indexOf(".");

        String[] str = this.getEmail().split("");

        for (int i = startIndex; i < endIndex; i++) {
            temp += str[i];
        }

        if (temp.equals("sci")) {
            return "Natural Science";
        }

        return "Social Science";
    }

    @Override
    public String toString() {
        return "Student [id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", age=" + this.getAge()
                + ", GPA=" + this.getGpa() + "]";
    }
}
