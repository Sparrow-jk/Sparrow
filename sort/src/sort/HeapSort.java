package sort;

/**
 * 堆排序
 *
 * @author Sparrow
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] tree = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        heapSort(tree);

        for (int i : tree) {
            System.out.println(i);
        }

    }

    private static void heapSort(int[] tree) {

        buildHeap(tree);

        int length = tree.length;
        for (int i = length - 1; i > 0; i--) {
            swap(i, 0, tree);
            heapify(tree, 0, i);
        }

    }


    /**
     * 构建堆
     *
     * @param tree 数组
     */
    private static void buildHeap(int[] tree) {

        int length = tree.length;
        int lastNode = length - 1;
        int parent = (lastNode - 1) / 2;

        for (int i = parent; i >= 0; i--) {
            heapify(tree, i, length);
        }

    }


    /**
     * 最小规模堆排序
     * 堆排序特点 2n+1 为左子节点 2n+2 为右子节点
     *
     * @param tree   数组树
     * @param parent 父节点位置
     * @param n      树长
     */
    private static void heapify(int[] tree, int parent, int n) {

        int child1 = 2 * parent + 1;
        int child2 = 2 * parent + 2;
        int max = parent;

        if (child1 < n && tree[child1] > tree[max]) {
            max = child1;
        }

        if (child2 < n && tree[child2] > tree[max]) {
            max = child2;
        }

        if (max != parent) {
            swap(max, parent, tree);
            //如果有子树，往下递归
            heapify(tree, max, n);
        }

    }

    /**
     * 数据交换
     *
     * @param child  子节点
     * @param parent 父节点
     * @param tree   数组树
     */
    private static void swap(int child, int parent, int[] tree) {

        tree[child] = tree[child] ^ tree[parent];
        tree[parent] = tree[child] ^ tree[parent];
        tree[child] = tree[child] ^ tree[parent];

    }
}
