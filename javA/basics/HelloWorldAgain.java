package basics;
public class HelloWorldAgain {

    String name;
    int age;
    boolean chad;
    int hp;
    int mp;

    public HelloWorldAgain(String myName, int myAge, boolean iAmChad) {

        this.name = myName;
        this.age = myAge;
        this.chad = iAmChad;

    }

    public void talk() {

        System.out.println("My name is "+this.name);
        System.out.println("I am "+this.age);
        System.out.println("Am I Chad? "+ this.chad);
    }



    public static void main(String[] args) {

        HelloWorldAgain someone = new HelloWorldAgain("An", 19, true);

        someone.talk();

    }
    
}