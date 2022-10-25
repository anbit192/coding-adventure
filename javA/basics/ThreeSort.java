package basics;
public class ThreeSort {

    public static void sortIncreaseInts(int a, int b, int c) {

        int maxValue=Math.max(Math.max(a,b),c);
        int minValue=Math.min(Math.min(a,b),c);
        int midValue=(a+b+c)-minValue-maxValue;
        
        System.out.println(minValue + " " + midValue + " " + maxValue);
    }
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]), b = Integer.parseInt(args[1]), c = Integer.parseInt(args[2]);    
        sortIncreaseInts(a, b, c);
        
        

    }   


}
