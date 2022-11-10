package oopexercises.collections.lists2;

public class MyArrayList extends MyAbstractList {
    private final int DEFAULT_CAPACITY = 16;
    private int size;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void print() {
        for (Object o:this.elements) {
            System.out.print(o);
        }
        System.out.println();
    }

    @Override
    public void add(Object o, int index) {
        if (this.size >= this.elements.length || index >= this.elements.length) {
            this.enlarge();
        }
        size++;

        Object[] newObjectArray = new Object[this.size];

        for (int i = 0; i < this.size; i++) {

            if (i < index) {
                newObjectArray[i] = this.elements[i];
            } else if (i > index) {
                newObjectArray[i] = this.elements[i - 1];
            } else {
                newObjectArray[i] = o;
            }
        }

        this.elements = newObjectArray;
    }

    @Override
    public void remove(int index) {
        Object[] newObjectArray = new Object[this.size - 1];
        for (int i = 0; i < this.size; i++) {
            if (i < index) {
                newObjectArray[i] = this.elements[i];
            } else if (i > index) {
                newObjectArray[i - 1] = this.elements[i];
            }
        }

        size--;
        this.elements = newObjectArray;


    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public void add(Object o) {
        if (this.size >= this.elements.length) {
            this.enlarge();
        }

        size++;
        elements[size-1] = o;
    }

    void enlarge() {
        Object[] temp = new Object[elements.length * 2];
        System.arraycopy(this.elements, 0, temp, 0, this.elements.length);
        elements = temp;
    }
}
