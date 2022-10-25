package oopexercises.classesandobjects.employee;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return this.getSalary() * 12;
    }

    public int raiseSalary(int percent) {
        this.setSalary(this.getSalary() + (this.getSalary() * percent)/100);
        return (this.getSalary());
    }

    @Override
    public String toString() {
        return String.format("[Employee[id = %d, name = %s, salary = %d]", this.getId(), this.getName(), this.getSalary());
    }
}
