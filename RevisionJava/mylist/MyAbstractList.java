package oop.mylist;

public abstract class MyAbstractList implements MyList {
    public MyAbstractList() {
    }

    public boolean checkBoundaries(int index, int maxIndex) {
        return index >= 0 && index <= maxIndex;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(String.format("[%s]", get(i).toString()));
        }

        return sb.toString();
    }
}
