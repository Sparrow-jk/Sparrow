public class TestMergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        mergeSort(arr,0,8);

        for (int i : arr) {
            System.out.println(i);
        }
    }


    private static void mergeSort(int[] arr, int l, int r) {
        if (r == l) {
            return;
        }
        int m = (r + l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m + 1, r);

    }


    private static void merge(int[] arr, int l, int m, int r) {

        int leftSize = m - l;
        int rightSize = r - m + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = l; i < m; i++) {
            left[i - l] = arr[i];
        }
        for (int i = m; i <= r; i++) {
            right[i - m] = arr[i];
        }

        int i = 0, j = 0, k = l;

        while (i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            k++;
            j++;
        }

    }
}
