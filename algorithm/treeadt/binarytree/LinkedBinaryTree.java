package treeadt.binarytree;

import java.util.Stack;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {

    private Node root;

    public LinkedBinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(E data) {
        this.root = new Node(data);
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
        Node current = getNodeByData(p);

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

        Node current = getNodeByData(p);
        if (current == null) {
            return null;
        }
        return current.getParent().getData();
    }

    @Override
    public E left(E p) {
        Node current = getNodeByData(p);
        if (current == null) {
            return null;
        }
        return current.getLeft().getData();
    }

    public void setLeft(E parent, E data) {

        Node parentNode = getNodeByData(parent);
        if (parentNode != null) {
            Node newNode = new Node(data);
            parentNode.setLeft(newNode);
        }
    }

    @Override
    public E right(E p) {
        Node current = getNodeByData(p);
        if (current == null) {
            return null;
        }
        return current.getRight().getData();
    }

    public void setRight(E parent, E data) {
        Node parentNode = getNodeByData(parent);
        if (parentNode != null) {
            Node newNode = new Node(data);
            parentNode.setRight(newNode);
        }
    }

    @Override
    public E sibling(E p) {
        Node current = getNodeByData(p);
        if (current == null || current == this.root) {
            return null;
        }

        Node parent = current.getParent();

        if (current == parent.getRight()) {
            return parent.getLeft().getData();
        } else if (current == parent.getLeft()) {
            return parent.getRight().getData();
        } else {
            return null;
        }
    }

    private Node getNodeByData(E data) {
        if (this.root == null) {
            return null;
        }
        Node current = root;
        Stack<Node> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {

            while (current != null) {

                stack.push(current);

                current = current.getLeft();
            }

            Node poppedNode = stack.pop();
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

        Node current = root;
        Stack<Node> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {

            while (current != null) {

                stack.push(current);

                current = current.getLeft();
            }

            Node poppedNode = stack.pop();
            current = poppedNode.getRight();

            sb.append(poppedNode.getData()).append(", ");
        }

        String str = sb.toString();
        str = str.substring(0, str.length() - 2);
        str += "]";

        return str;
    }

    protected class Node {
        private E data;
        private Node parent;
        private Node left;
        private Node right;


        public Node(E data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
