package treeadt.binarytree.binarysearchtree;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();


    }

    public static boolean isIncreasing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isBST(BinarySearchTree.Node<Integer> node, int size) {

        if (node == null) {
            return true;
        }

        int[] array = new int[size];

        treeToArray(node, array, 0);

        return isIncreasing(array);
    }

    private static void treeToArray(BinarySearchTree.Node<Integer> node, int[] array, int n) {
        if (node == null) {
            return;
        }

        treeToArray(node.left, array, n);
        array[n] = node.data;
        n++;
        treeToArray(node.right, array, n);
    }
}
