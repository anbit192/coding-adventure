package adtstackandqueue.stack;

import java.util.Iterator;

public class TestLinkedStack {
    public static void main(String[] args) {

        //constructor
        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        //push
        linkedStack.push(192);


        //toString
        System.out.println(linkedStack);

        //pop
        linkedStack.pop();
        linkedStack.pop();

        System.out.println(linkedStack);

        //top
        linkedStack.push(190203);
        linkedStack.push(123);

        System.out.println(linkedStack);

        System.out.println(linkedStack.top());

        //isEmpty
        System.out.println(linkedStack.isEmpty());

        //iterator
        Iterator<Integer> stackIterator = linkedStack.iterator();
        System.out.println(stackIterator.next());
        System.out.println(stackIterator.next());

        for (int item : linkedStack) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
