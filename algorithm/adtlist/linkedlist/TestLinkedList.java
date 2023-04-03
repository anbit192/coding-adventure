package adtlist.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        /*list.addTop(19);
        list.addBot(192);
        list.add(123, 0);
        list.print();



        list.removeBot();
        System.out.println("asdak");
        list.print();

        list.addTop(123456);
        list.print();

        list.addTop(192);
        list.print();

        list.addBot(1234);
        list.print();

        list.removeTop();
        list.remove(1234);
        list.removeTop();

        System.out.println("asdasd");
        list.print();*/

        list.add(192, 0);
        list.addBot(1234);
        list.addBot(192);
        list.addBot(1234);
        list.addBot(192);
        list.addBot(1234);
        list.addBot(192);
        list.addBot(1234);
        list.print();

        list.remove(1234);
        list.remove(192);
        list.print();


    }

}
