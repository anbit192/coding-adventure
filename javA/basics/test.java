package basics;

public class test {
    public static void main(String[] args) {
        String str = "a b c d e f g h i ef ffs asd";

        String[] array = str.split("\\s+");
        for (String item : array) {
            System.out.println(item);
        }
    }
 }
