package sort;

public class Tree {

    private static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.data = 5;
        node2.data = 6;
        node3.data = 7;
        node4.data = 8;

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = null;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;

        perOrder(node1);
        System.out.println("--------------------");
        inOrder(node1);
        System.out.println("--------------------");
        postOrder(node1);

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


}
