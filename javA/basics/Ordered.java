package basics;
public class Ordered {
    
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]), b = Integer.parseInt(args[1]), c = Integer.parseInt(args[2]);

        boolean result = ( (a > b) && (b > c) ) || ( (a < b) && (b < c) );

        System.out.println(result);
    }
}
