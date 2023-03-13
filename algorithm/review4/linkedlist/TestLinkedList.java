package review4.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        list.addFirst(19);
        list.addBot(192);
        list.add(123, 0);
        list.print();


        list.removeTop();
        list.removeTop();
        list.removeBot();
        System.out.println("asdak");
        list.print();

        list.addFirst(123456);
        list.print();

        list.addFirst(192);
        list.print();

        list.addBot(1234);
        list.print();

        list.removeTop();
        list.remove(1234);
        list.removeTop();

        System.out.println("asdasd");
        list.print();

        list.add(192, 0);
        list.print();


    }

}
