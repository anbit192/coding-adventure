package adtstack.stack.brackets;

import adtstack.stack.ListStack;
import adtstack.stack.StackInterface;

import java.util.ArrayList;
import java.util.List;

public class BracketCheck {

    public static void main(String[] args) {

        List<String> maths = generate();

        for (String math : maths) {
            System.out.println(math + " : " + checkBracket(math));
        }
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

    private static ArrayList<String> generate() {
        ArrayList<String> maths = new ArrayList<>();

        String math1 = "(10 – 8) / ( (2 + 5) * 17)";
        String math2 = "(a + b) * (c – d)";
        String math3 = "(a + b) * c – d)";
        String math4 = "(10 – 8 / ( (2 + 5) * 17)";
        String math5 = ") u – v) * (m + n)";

        maths.add(math1);
        maths.add(math2);
        maths.add(math3);
        maths.add(math4);
        maths.add(math5);


        return maths;
    }

}
