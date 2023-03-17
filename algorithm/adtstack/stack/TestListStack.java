package adtstack.stack;

public class TestListStack {
    public static void main(String[] args) {
        StackInterface<String> stack = new ListStack<>();

        //push
        stack.push("m");
        stack.push("m");
        stack.push("c");
        stack.push("d");

        //toString
        System.out.println(stack);

        //pop
        stack.pop();
        stack.pop();
        System.out.println(stack);

        //top
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());

        //iterator
        stack.push("y");
        stack.push("m");
        stack.push("t");
        stack.push("z");

        for (String item : stack) {
            System.out.print(item + " ");
        }

        System.out.println();

        //isEmpty
        System.out.println(stack.isEmpty());

    }
}
