package review4.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        list.addFirst(19);
        list.addBot(192);
        list.add(123, 1);
        list.add(999, 1);
        list.addFirst(192);
        list.addFirst(192);
        list.addFirst(192);

        list.addBot(69);

        list.removeTop();
        list.removeBot();
        list.removeIndex(1);
        list.remove(192);

        list.print();

    }

}
