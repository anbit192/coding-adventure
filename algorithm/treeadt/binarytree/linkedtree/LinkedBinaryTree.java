package treeadt.binarytree.linkedtree;

import treeadt.binarytree.BinaryTreeInterface;
import java.util.Stack;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {

    Node<E> root;

    public LinkedBinaryTree() {
        this.root = null;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(E data) {
        this.root = new Node<>(data, root.left, root.right);

    }

    @Override
    public E root() {
        return this.root.getData();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int numChildren(E p) {
        Node<E> current = getNodeByData(p);

        if (current == null) {
            return -1;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            return 0;
        } else if (current.getLeft() != null && current.getRight() != null) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public E parent(E p) {

        Node<E> current = getNodeByData(p);
        if (current == null) {
            return null;
        }
        return current.getParent().getData();
    }

    @Override
    public E left(E p) {
        Node<E> current = getNodeByData(p);
        if (current == null) {
            return null;
        }
        return current.getLeft().getData();
    }

    public void setLeft(E parent, E data) {

        Node<E> parentNode = getNodeByData(parent);
        if (parentNode != null) {
            Node<E> newNode = new Node(data);
            parentNode.setLeft(newNode);
        }
    }

    @Override
    public E right(E p) {
        Node<E> current = getNodeByData(p);
        if (current == null) {
            return null;
        }
        return current.getRight().getData();
    }

    public void setRight(E parent, E data) {
        Node<E> parentNode = getNodeByData(parent);
        if (parentNode != null) {
            Node<E> newNode = new Node(data);
            parentNode.setRight(newNode);
        }
    }

    @Override
    public E sibling(E p) {
        Node<E> current = getNodeByData(p);
        if (current == null || current == this.root) {
            return null;
        }

        Node<E> parent = current.getParent();

        if (current == parent.getRight()) {
            return parent.getLeft().getData();
        } else if (current == parent.getLeft()) {
            return parent.getRight().getData();
        } else {
            return null;
        }
    }

    private Node<E> getNodeByData(E data) {
        if (this.root == null) {
            return null;
        }
        Node<E> current = root;
        Stack<Node<E>> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {

            while (current != null) {

                stack.push(current);

                current = current.getLeft();
            }

            Node<E> poppedNode = stack.pop();
            if (poppedNode.getData() == data) {
                return poppedNode;
            }

            current = poppedNode.getRight();

        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Node<E> current = root;
        Stack<Node<E>> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {

            while (current != null) {

                stack.push(current);

                current = current.getLeft();
            }

            Node<E> poppedNode = stack.pop();
            current = poppedNode.getRight();

            sb.append(poppedNode.getData()).append(", ");
        }

        String str = sb.toString();
        str = str.substring(0, str.length() - 2);
        str += " ]";

        return str;
    }

    static class Node<E> {
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

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
}
