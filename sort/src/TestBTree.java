import sort.BTree;

public class TestBTree {

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};
        Tree tree = new Tree();
        tree.root = null;

        for (int i : arr) {
            insert(tree, i);
        }

        System.out.println(getHeight(tree.root));


    }


    private static int getHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int leftMax = getHeight(node.left);
        int rightMax = getHeight(node.right);
        return Math.max(leftMax, rightMax) + 1;


    }

    private static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }

    private static class Tree {
        Node root;
    }

    private static void insert(Tree tree, int value) {

        Node node = new Node();
        node.left = null;
        node.right = null;
        node.data = value;

        if (tree.root == null) {
            tree.root = node;
        } else {
            Node temp = tree.root;
            while (true) {

                if (value < temp.data) {
                    if (temp.left == null) {
                        temp.left = node;
                        return;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        return;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }

    }


}
