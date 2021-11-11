import java.util.ArrayDeque;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/25 10:34
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Test {
    public static void main(String[] args) {

        int[] tree = {1, 4, 7};
        swap(tree, 0, 2);
        for (int i :tree){
            System.out.println(tree[i]);
        }

    }


    private static void heapify(int[] tree, int parent, int n) {

        int child1 = parent * 2 + 1;
        int child2 = parent * 2 + 2;
        int max = parent;

        if (tree[child1] > tree[max]) {
            swap(tree, child1, max);
        }
        if (child2 > max) {

        }


    }

    private static void swap(int[] tree, int child1, int max) {

        tree[child1] = tree[child1] ^ tree[max];
        tree[max] = tree[child1] ^ tree[max];
        tree[child1] = tree[max] ^ tree[child1];
    }
}
