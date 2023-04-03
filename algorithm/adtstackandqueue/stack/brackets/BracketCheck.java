package adtstackandqueue.stack.brackets;

import adtstackandqueue.stack.ListStack;
import adtstackandqueue.stack.StackInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketCheck {

    public static void main(String[] args) {

        List<String> maths = generate();

        for (String str : maths) {
            System.out.println(checkBracket(str));;
        }

        String exp = "(10 - 8) / ( (2 + 5) * 17)";

        System.out.println(evaluate(exp));
    }

    public static boolean checkBracket(String math) {

        StackInterface<Character> stack = new ListStack<>();

        math = math.replaceAll("\\s+", "");

        char[] chars = math.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();

                }
            }
        }

        return stack.isEmpty();
    }

    public static String addBracket(String exp) {
        if (checkBracket(exp)) {
            int countBrackets = 0;
            int countOperator = 0;

            for (int i = 0; i < exp.length(); i++) {
                if (exp.equals("(")) {
                    countBrackets++;
                } else if (isOperation(exp.charAt(i))) {
                    countOperator++;
                }
            }

            if (countBrackets < countOperator) {
                exp = '(' + exp + ')';
            }

        }
        return exp;
    }

    private static boolean isOperation(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '%' || c == '^');
    }

    public static double evaluate(String str) {

        if (!checkBracket(str)) {
            System.out.println("Invalid exp!");
            return 0;
        }

        Stack<Character> operations = new Stack<>();
        Stack<Double> numbers = new Stack<>();

        str = str.replaceAll("\\s+", "");
        str = addBracket(str);


        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || isOperation(chars[i])) {
                operations.push(chars[i]);
            } else if (Character.isDigit(chars[i])) {
                String temp = Character.toString(chars[i]);
                if (Character.isDigit(chars[i + 1])) {
                    temp += chars[i + 1];
                    i++;
                }

                numbers.push(Double.valueOf(temp));

            } else if (chars[i] == ')') {
                Double n2 = numbers.pop();
                Double n1 = numbers.pop();
                char operator = operations.pop();
                double sum = operate(n1, operator, n2);
                numbers.push(sum);
                operations.pop();
            }
        }

        return numbers.pop();
    }

    public static double operate(double n1, char operation, double n2) {
        double sum = 0;
        switch (operation) {
            case ('+'):
                sum = n1 + n2;
                break;
            case ('-'):
                sum = n1 - n2;
                break;
            case ('/'):
                sum = n1 / n2;
                break;
            case ('*'):
                sum = n1 * n2;
                break;
        }

        return sum;
    }


    private static ArrayList<String> generate() {
        ArrayList<String> maths = new ArrayList<>();

        String math1 = "(10 - 8) / ( (2 + 5) * 17)";
        String math2 = "(a + b) * (c - d)";
        String math3 = "(a + b) * c - d)";
        String math4 = "(10 - 8 / ( (2 + 5) * 17)";
        String math5 = ") u - v) * (m + n)";

        maths.add(math1);
        maths.add(math2);
        maths.add(math3);
        maths.add(math4);
        maths.add(math5);


        return maths;
    }

}
