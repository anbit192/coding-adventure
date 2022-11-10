package oopexercises.collections.phonebook;

public interface PhoneBook {
    Student searchByLastName(String lastName);

    Student searchByName(String name);

    Student searchByNumber(String number);

    void addPerson(Student student);

    void deleteByNumber(String number);
}
