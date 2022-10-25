package basics;

public class ConvertUnit1{
    
    public static double converter(double x) {

        double convertedValue = (double) (x * 39.3700787);
        return convertedValue;

    }
    public static void main(String[] args) {

        double input = Double.parseDouble(args[0]);
        double convertedValue=converter(input);
        System.out.println(Math.round(convertedValue*100.0)/100.0);

        
        
        
    }
    
}