package oopexercises.collections.phonebook;

import java.util.HashMap;

public class PhoneBookMap implements PhoneBook {

    HashMap<String, Student> phoneBook;

    public PhoneBookMap() {
        phoneBook = new HashMap<>();
    }

    @Override
    public Student searchByLastName(String lastName) {
        for (Student person : phoneBook.values()) {
            if (person.lastName.equals(lastName)) {
                return person;
            }
        }

        return null;
    }

    @Override
    public Student searchByName(String name) {
        for (Student person : phoneBook.values()) {
            if (person.name.equals(name)) {
                return person;
            }
        }

        return null;
    }

    @Override
    public Student searchByNumber(String number) {
        for (Student person : phoneBook.values()) {
            if (person.phone.equals(number)) {
                return person;
            }
        }

        return null;
    }

    @Override
    public void addPerson(Student student) {
        phoneBook.put(student.phone, student);
    }

    @Override
    public void deleteByNumber(String number) {
        phoneBook.remove(number);
    }
}
