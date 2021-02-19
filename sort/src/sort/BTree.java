package sort;

public class BTree {

    private static class Node {
        int data;
        Node left;
        Node right;
    }

    private static class Tree {
        BTree.Node root;
    }

    private static void insert(Tree tree, int value) {

        Node node = new Node();
        node.data = value;
        node.left = null;
        node.right = null;

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


    /**
     * 树高
     */
    private static int getHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int max = Math.max(leftHeight, rightHeight);

        return max + 1;

    }


    /**
     * 先序遍历
     */
    private static void perOrder(Node node) {

        if (node != null) {
            System.out.println(node.data);
            perOrder(node.left);
            perOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    private static void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     */
    private static void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};
        Tree tree = new Tree();
        tree.root = null;

        for (int i : arr) {
            insert(tree, i);
        }

        int height = getHeight(tree.root);

        System.out.println(height);
    }
}
