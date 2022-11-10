package oopexercises.collections.maps2;

import java.util.Objects;

public class MyHashMap implements MyMap {

    final static int INITIAL_SIZE = 8;
    MyHashMapEntry[] table;
    int size = 0;

    public MyHashMap() {
        table = new MyHashMapEntry[INITIAL_SIZE];
    }

    int getBucket(Object key) {
        int bucket = (Math.abs(key.hashCode()) % table.length);
        while (table[bucket] != null && table[bucket].getKey() != key) {
            bucket = (bucket + 1) % table.length;
        }
        return bucket;
    }

    void enlarge() {
        MyHashMapEntry[] newMapEntry = new MyHashMapEntry[2 * this.table.length];
        System.arraycopy(this.table, 0, newMapEntry, 0, this.table.length);
        this.table = newMapEntry;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(Object key, Object value) {
        int bucket = getBucket(key);
        if (bucket > this.table.length) {
            this.enlarge();
        }

        if (Objects.isNull(this.table[bucket])) {
            this.size++;
        }

        this.table[bucket] = new MyHashMapEntry(key, value);
    }

    @Override
    public void remove(Object key) {
        MyHashMapEntry[] newMapEntry = new MyHashMapEntry[this.table.length];

        int bucket = this.getBucket(key);
        for (int i = 0; i < this.table.length; i++) {
            if (i < bucket) {
                newMapEntry[i] = this.table[i];
            } else if (i > bucket) {
                newMapEntry[i] = this.table[i];
            } else {
                newMapEntry[i] = null;
            }
        }
        this.size--;
        this.table = newMapEntry;

    }

    @Override
    public boolean contains(Object key) {
        for (MyHashMapEntry entry : this.table) {
            if (!(Objects.isNull(entry)) && entry.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object get(Object key) {
        int bucket = getBucket(key);
        if (table[bucket] != null) {
            return table[bucket].getValue();
        }

        return -1;
    }

    double capacityRatio() {
        return this.size / (double) table.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.table.length; i++) {
            if (table[i] == null) {
                sb.append(String.format("[bucket %d] -> null\n", i));
            } else {
                sb.append(String.format("[bucket %d] -> (%s, %s)\n", i, table[i].getKey(), table[i].getValue()));
            }
        }

        return sb.toString();
    }
}

