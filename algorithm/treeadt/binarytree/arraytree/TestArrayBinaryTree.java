package treeadt.binarytree.arraytree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree<String> tree = new ArrayBinaryTree<>();

        // tree.add("ROOT");

        tree.add("1");
        tree.add("2");
        tree.add("3");
        tree.add("4");
        tree.add("5");
        tree.add("6");
        tree.add("7");
        tree.add("8");

        System.out.println(tree.right("1"));
        System.out.println(tree.left("1"));
        System.out.println(tree.parent("8"));
        System.out.println(tree.left("3"));
        System.out.println(tree.right("3"));

        System.out.println((tree).parent("5"));
        System.out.println((tree).parent("6"));

        System.out.println(tree.numChildren("4"));
        System.out.println(tree.right("4"));
        System.out.println(tree.sibling("6"));
        System.out.println(tree);
    }
}
