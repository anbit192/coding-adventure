package designpatterns.singleton.database;

public class TestSingleton {
    public static void main(String[] args) {
        Database db1 = Database.getInstance(); // create new instance
        Database db2 = Database.getInstance(); // return existed instance
        System.out.println(db1);
        System.out.println(db2);
    }
}
