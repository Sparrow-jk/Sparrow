public class TestBubbleSort {


    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        bubbleSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }


    private static void bubbleSort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            bubble(arr, i);
        }
    }


    private static void bubble(int[] arr, int n) {

        for (int i = 0; i < n; i++) {

            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }

    }


    private static void swap(int[] tree, int node1, int node2) {

        tree[node1] = tree[node1] ^ tree[node2];
        tree[node2] = tree[node1] ^ tree[node2];
        tree[node1] = tree[node1] ^ tree[node2];

    }
}
