package treeadt.binarytree.linkedtree;

import java.util.Stack;

public class TestLinkedBinaryTree {

    public static void main(String[] args) {

        String exp = convertToRPN("(((6/2) + 3) * (7 - 4))"); // 1 () per operation
        System.out.println(exp);

        ExpressionTree<Character> tree = generateExpTree(exp);
        System.out.println(tree.root.data);
        tree.inOrderPrint(tree.getRoot());
        System.out.println();

        tree.preOrderPrint(tree.getRoot());
        System.out.println();

        tree.postOrderPrint(tree.getRoot());
        System.out.println();

        System.out.println(evaluate(tree.root));

        drawTree(tree.root, 0);

    }

    public static ExpressionTree<Character> generateExpTree(String exp) {
        ExpressionTree<Character> expTree = new ExpressionTree<>();
        Stack<LinkedBinaryTree.Node<Character>> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (!Character.isDigit(c)) {
                LinkedBinaryTree.Node<Character> right = stack.pop();
                LinkedBinaryTree.Node<Character> left = stack.pop();

                LinkedBinaryTree.Node<Character> operator = new LinkedBinaryTree.Node<>(c, left, right);
                stack.push(operator);

            } else if (Character.isDigit(c)) {
                LinkedBinaryTree.Node<Character> node = new LinkedBinaryTree.Node<>(c);
                stack.push(node);
            }
        }

        expTree.root = stack.pop();


        return expTree;
    }

    public static double evaluate(LinkedBinaryTree.Node<Character> node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return Double.parseDouble(String.valueOf(node.data));
        }

        double leftResult = evaluate(node.left);
        double rightResult = evaluate(node.right);

        return operate(leftResult, node.data, rightResult);
    }

    public static String convertToRPN(String exp) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (isOperation(c)) {
                operators.push(c);
            } else if (c == ')') {
                sb.append(operators.pop());
            }
        }

        return sb.toString();
    }

    private static boolean isOperation(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '%' || c == '^');
    }

    private static double operate(double left, char operation, double right) {
        double result = switch (operation) {
            case ('+') -> left + right;
            case ('-') -> left - right;
            case ('*') -> left * right;
            case ('/') -> left / right;
            case ('^') -> Math.pow(left, right);
            default -> 0;
        };

        return result;
    }

    public static void drawTree(LinkedBinaryTree.Node<Character> node, int whiteSpace) {
        
        int count = 5;

        if (node == null) {
            return;
        }

        whiteSpace += count;

        drawTree(node.right, whiteSpace);
        
        //System.out.println("");
        for (int i = 0; i < whiteSpace; i++) {
            System.out.print(" ");
        }
        System.out.println(node.data);
        System.out.println();

        drawTree(node.left, whiteSpace);
    }
}
