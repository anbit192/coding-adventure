package treeadt.binarytree.linkedtree;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {

    public void preOrderPrint(Node<E> p) {
        if (p == null) {
            return;
        }

        System.out.print(p.getData() + " ");
        preOrderPrint(p.getLeft());
        preOrderPrint(p.getRight());
    }

    public void postOrderPrint(Node<E> p) {
        if (p == null) {
            return;
        }

        postOrderPrint(p.getLeft());
        postOrderPrint(p.getRight());

        System.out.print(p.getData() + " ");
    }

    public void inOrderPrint(Node<E> p) {
        if (p == null) {
            return;
        }

        inOrderPrint(p.getLeft());
        System.out.print(p.getData() + " ");
        inOrderPrint(p.getRight());
    }



}
