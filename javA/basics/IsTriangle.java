package basics;
public class IsTriangle
{
    
    static boolean isTriangle(double a, double b, double c)
    {
        // begin edit 
        if (a+b>c && b+c>a && a+c>b && a > 0 && b > 0 && c > 0)  {

            return true;
        }
        else {
            return false;
        
        }
        //end edit
    }
    public static void main (String args[])
    {
        double a = Double.parseDouble(args[0]) , b = Double.parseDouble(args[1]) , c = Double.parseDouble(args[2]);
        System.out.println(isTriangle(a, b, c));
    }

    
}
