package sort;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int l, int r) {

        if (l > r) {
            return;
        }

        int povit = arr[l], i = l, j = r;

        while (i != j) {

            while (arr[j] >= povit && i < j) {
                j--;
            }

            while (arr[i] <= povit && i < j) {
                i++;
            }

            if (i != j) {
                swap(arr, i, j);
            }

        }

        arr[l] = arr[i];
        arr[i] = povit;

        quickSort(arr, l, i - 1);
        quickSort(arr, j + 1, r);

    }

    private static void swap(int[] tree, int node1, int node2) {

        tree[node1] = tree[node1] ^ tree[node2];
        tree[node2] = tree[node1] ^ tree[node2];
        tree[node1] = tree[node1] ^ tree[node2];

    }

}
