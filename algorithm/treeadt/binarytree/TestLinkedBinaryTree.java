package treeadt.binarytree;

public class TestLinkedBinaryTree {
    public static void main(String[] args) {

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        tree.setRoot("An");

        tree.setRight("An", "Onodera Kosaki");
        tree.setLeft("An", "Ganyu");

        tree.setRight("Ganyu", "Chiaki Nanami");
        tree.setLeft("Ganyu", "Seele Volerei");

        tree.setLeft("Onodera Kosaki", "Haruhi Suzumiya");
        tree.setRight("Onodera Kosaki", "Nira chan");

        System.out.println(tree);

    }
}
