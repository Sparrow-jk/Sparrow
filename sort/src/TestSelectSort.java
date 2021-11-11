public class TestSelectSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        selectSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }


    private static void selectSort(int[] arr) {

        int length = arr.length;

        for (int i = length - 1; i >= 0; i--) {
            int selectMaxIndex = select(arr, i);

            if (arr[selectMaxIndex] > arr[i]) {
                swap(arr, selectMaxIndex, i);
            }
        }

    }


    private static int select(int[] arr, int n) {

        int max = arr[n];
        int maxIndex = n;

        for (int i = 0; i <= n; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    private static void swap(int[] tree, int node1, int node2) {

        tree[node1] = tree[node1] ^ tree[node2];
        tree[node2] = tree[node1] ^ tree[node2];
        tree[node1] = tree[node1] ^ tree[node2];

    }
}
