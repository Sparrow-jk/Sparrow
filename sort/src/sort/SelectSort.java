package sort;

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        selectSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }


    private static void selectSort(int[] arr) {

        int length = arr.length - 1;

        while (length >= 0) {
            int index = findMaxIndex(arr, length);
            if (arr[index] > arr[length]) {
                swap(index, length, arr);
            }
            length--;
        }

    }


    private static int findMaxIndex(int[] arr, int n) {
        int max = arr[n];
        int maxIndex = n;

        for (int i = 0; i <= n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private static void swap(int node1, int node2, int[] arr) {

        arr[node1] = arr[node1] ^ arr[node2];
        arr[node2] = arr[node1] ^ arr[node2];
        arr[node1] = arr[node1] ^ arr[node2];

    }
}
