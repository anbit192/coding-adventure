package oopexercises.collections.phonebook;

import java.util.ArrayList;

public class PhoneBookList implements PhoneBook {

    ArrayList<Student> phoneBook;

    public PhoneBookList() {
        phoneBook = new ArrayList<>();
    }

    @Override
    public Student searchByLastName(String lastName) {
        for (Student student : phoneBook) {
            if (student.lastName.equals(lastName)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public Student searchByName(String name) {
        for (Student student : phoneBook) {
            if (student.name.equals(name)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public Student searchByNumber(String number) {
        for (Student student : phoneBook) {
            if (student.phone.equals(number)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public void addPerson(Student student) {
        phoneBook.add(student);
    }

    @Override
    public void deleteByNumber(String number) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).phone.equals(number)) {
                phoneBook.remove(i);
            }
        }
    }
}
