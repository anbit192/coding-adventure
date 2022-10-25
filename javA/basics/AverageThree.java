package basics;
/**
 * Program to calculate the average of three (double) numbers
 * The arguments are entered from command line 
 * Use the function Double.parseDouble(String strNumber) to
 * convert a string in (real) number format to its value
 */
public class AverageThree {

    public static void main(String[] args) {

        {

        Double a = Double.parseDouble(args[0]) , b = Double.parseDouble(args[1]), c = Double.parseDouble(args[2]);

        Double averageSum = (a+b+c)/3;

        System.out.println(averageSum);
        }
    }
}