package oopexercises.inheritance.person;

public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Student("An", "abc", "wibu", 2077, 69);
        Person person2 = new Staff("Asuka", "EVA 02", "abc", 96);

        System.out.println(person2);
        System.out.println(person1);
    }
}
