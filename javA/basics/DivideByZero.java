package basics;


public class DivideByZero {
    public static void main(String[] args) {

    int a = Integer.parseInt(args[0]);
    double b = Double.parseDouble(args[1]);
    int v = 0;    

    System.out.println(a);
    System.out.println(b);
    System.out.println(a/b);
    System.out.println(b/v);
    }

}
