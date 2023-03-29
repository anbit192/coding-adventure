package treeadt.binarytree;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {

    private static final int DEFAULT_SIZE = 100;
    private int size;
    private E[] array;

    public ArrayBinaryTree() {
        this.size = 0;
        this.array = (E[]) new Object[DEFAULT_SIZE];
    }

    public ArrayBinaryTree(int capacity) {
        this.size = 0;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public E root() {
        return this.array[0];
    }

    public void setRoot(E element) {
        this.array[0] = element;
        if (this.size == 0) {
            this.size++;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int numChildren(E p) {
        if (this.left(p) == null || this.right(p) == null) {
            return 1;
        } else if (!(this.left(p) == null && this.right(p) == null)) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public E parent(E p) {
        int idx = this.getIndex(p);
        if (p == this.root() || idx == -1) {
            return null;
        } else {
            if (idx % 2 != 0) {
                return this.array[(idx - 1) / 2];
            } else {
                return this.array[(idx - 2) / 2];
            }
        }
    }

    @Override
    public E left(E p) {
        if (this.getIndex(p) == -1) {
            return null;
        }

        return this.array[this.getIndex(p) * 2 + 1];
    }

    public void setLeft(int p, E element) {
        int childIndex = 2 * p + 1;
        if (this.array[p] != null) {
            if (childIndex >= this.array.length) {
                this.enlarge();
            }

            if (this.array[childIndex] == null) {
                this.size++;
            }
            this.array[childIndex] = element;

        }
    }

    @Override
    public E right(E p) {
        if (this.getIndex(p) == -1) {
            return null;
        }

        return this.array[this.getIndex(p) * 2 + 2];
    }

    public void setRight(int p, E element) {
        int childIndex = 2 * p + 2;
        if (this.array[p] != null) {

            if (childIndex >= this.array.length) {
                this.enlarge();
            }

            if (this.array[childIndex] == null) {
                this.size++;
            }
            this.array[childIndex] = element;

        }
    }

    @Override
    public E sibling(E p) {
        if (this.getIndex(p) == -1 || this.getIndex(p) == 0) {
            return null;
        }

        if (this.getIndex(p) % 2 == 0) { //right children
            int parentIndex = (this.getIndex(p) - 2) / 2;
            return this.left(this.array[parentIndex]);
        } else { //left children
            int parentIndex = (this.getIndex(p) - 1) / 2;
            return this.right(this.array[parentIndex]);
        }
    }

    private int getIndex(E item) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == item) {
                return i;
            }
        }

        return -1;
    }

    private void enlarge() {
        E[] newArray = (E[]) new Object[this.array.length * 2];
        if (this.size >= this.array.length) {
            System.arraycopy(this.array, 0, newArray, 0, this.size);
        }

        this.array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (int i = 0; i < this.size; i++) {

            if (this.array[i] == null) {
                i++;
            }

            if (i == size - 1) {
                sb.append(array[i]).append(" ]");

            } else {
                sb.append(array[i]).append(", ");

            }
        }

        sb.append("\nSize = ").append(this.size);

        return sb.toString();
    }
}
