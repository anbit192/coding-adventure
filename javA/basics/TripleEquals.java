package basics;
public class TripleEquals {

    public static void equalCheck(String a, String b, String c) {

        System.out.println( ( ( a.equals(b) ) && ( a.equals(c) ) ) );


    }
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        String c = args[2];

        equalCheck(a, b, c);

        

    }
}