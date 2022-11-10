package oopexercises.collections.lists2;

public class MyAbstractList implements MyList {

    public MyAbstractList() {
    }

    void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(String.format("[%s]", get(i).toString()));
        }

        return sb.toString();
    }

    @Override
    public void add(Object o, int number) {

    }

    @Override
    public void remove(int number) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(int number) {
        return null;
    }

    @Override
    public void add(Object o) {

    }
}
