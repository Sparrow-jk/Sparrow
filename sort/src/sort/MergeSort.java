package sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        mergeSort(arr, 0, 8);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 分治
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void mergeSort(int[] arr, int l, int r) {

        if (l == r) {
            return;
        }

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m + 1, r);

    }


    /**
     * 合并
     *
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    private static void merge(int[] arr, int l, int m, int r) {

        int leftSize = m - l;
        int rightSize = r - m + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        //填充左数组
        for (int i = l; i < m; i++) {
            left[i - l] = arr[i];
        }

        //填充右数组
        for (int i = m; i <= r; i++) {
            right[i - m] = arr[i];
        }

        //排列数组
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

        //左边剩余
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        //右边剩余
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}

