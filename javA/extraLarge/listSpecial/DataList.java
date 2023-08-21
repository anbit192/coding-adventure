package extraLarge.listSpecial;

import java.util.ArrayList;

// a custom list for data
public abstract class DataList<E> {
    protected ArrayList<E> elements;

    public DataList() {
        this.elements = new ArrayList<E>();
    }

    public abstract int searchByType(E type, E value);

    public void add(E object) {
        elements.add(object);
    }

    public ArrayList<E> getElements() {
        return elements;
    }

    public int size() {
        return this.elements.size();
    }
}
