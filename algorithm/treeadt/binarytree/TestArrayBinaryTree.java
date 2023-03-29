package treeadt.binarytree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree<String> tree = new ArrayBinaryTree<>();

        tree.setRoot("ROOT");

        tree.setLeft(0, "1");
        tree.setRight(0, "2");

        tree.setLeft(1, "ichi");
        tree.setRight(1 , "one");

        tree.setLeft(2, "ni");
        tree.setRight(2, "two");

        System.out.println("right children of node '1': " + tree.right("1"));
        System.out.println("sibling of node 'ichi': " + tree.sibling("ichi"));
        System.out.println(tree);
    }
}
