package oopexercises.collections.phonebook;

public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBookList();
        pb.addPerson(new Student("an","bish","1234"));
        pb.addPerson(new Student("asd","dfg","3245"));

        System.out.println(pb.searchByLastName("bish"));

    }
}
