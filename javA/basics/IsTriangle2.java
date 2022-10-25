package basics;
import java.util.Scanner;

public class IsTriangle2 {
    
    public static boolean isTriangle(double a, double b, double c) {

        if (a+b>c && b+c>a && a+c>b && a > 0 && b > 0 && c > 0)  {

            return true;
        }
        else {
            return false;
        
        }

    }
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        
        System.out.println(isTriangle(a,b,c));
        scan.close();
    }
}
