package basics;
public class Triangle {

    public static double getArea( double a, double b, double c) {

        if (a+b>c && b+c>a && a+c>b && a > 0 && b > 0 && c > 0) {
            double halfCircum = (a+b+c)/2;

            double area = ( Math.sqrt( halfCircum * (halfCircum - a) * (halfCircum - b) * (halfCircum - c) ) );

            return area;
        }

        else {
            return 0;
        }

    }

    public static void main(String[] args) {

        double a = Double.parseDouble(args[0]), b = Double.parseDouble(args[1]), c = Double.parseDouble(args[2]);

        double area = getArea(a,b,c);

        System.out.println(area);
    }
    
}
