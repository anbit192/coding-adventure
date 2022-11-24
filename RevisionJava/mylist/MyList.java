package oop.mylist;

import java.util.Objects;

public interface MyList {

    void add(Object o);

    void add(Object o, int index);

    Object get(int index);

    void remove(int index);

    int size();
}
