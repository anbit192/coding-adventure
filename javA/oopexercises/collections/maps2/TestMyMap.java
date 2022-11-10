package oopexercises.collections.maps2;

public class TestMyMap {
    public static void main(String[] args) {
        MyMap m = new MyHashMap();
        m.put(11, "nicola");
        m.put(11, "nicola");
        m.put(21, "marzia");
        m.put(33, "agata");
        m.put(192, "anbish");
        System.out.println(m);
        System.out.println(m.size());

        System.out.println(m);

        System.out.println(m.contains(11));
        m.remove(33);
        m.remove(21);
        System.out.println(m);
        System.out.println(m.contains(77));
        System.out.println(m.size());

    }
}
