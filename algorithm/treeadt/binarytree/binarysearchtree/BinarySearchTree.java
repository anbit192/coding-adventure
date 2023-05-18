package treeadt.binarytree.binarysearchtree;

public class BinarySearchTree<E extends Comparable<E>> {

    Node<E> root;
    int size;


    public BinarySearchTree() {
        this.root = null;
    }

    public Node<E> search(Node<E> node, E data) {
        if (node == null || node.data == data) {
            return node;
        } else if (node.data.compareTo(data) < 0) {
            return search(node.right, data);
        } else {
            return search(node.left, data);
        }
    }

    private Node<E> insertRecursive(Node<E> node, E data) {

        // Reach the leaf node
        if (node == null) {
            node = new Node<>(data);
            size++;
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    public void insert(E data) {
        this.root = insertRecursive(this.root, data);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }

    public void inOrder() {
        inOrder(this.root);
    }

    public static class Node<E> {
        E data;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> parent) {
            this.data = data;
            this.parent = parent;
        }

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
