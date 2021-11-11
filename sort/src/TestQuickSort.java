public class TestQuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        quickSort(arr, 0, 8);

        for (int i : arr) {
            System.out.println(i);
        }
    }


    private static void quickSort(int[] arr, int l, int r) {

        if (l > r) {
            return;
        }

        int pivot = arr[l], i = l, j = r;

        while (i != j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            if (i != j) {
                swap(arr, i, j);
            }
        }

        arr[l] = arr[i];
        arr[i] = pivot;

        quickSort(arr, l, i - 1);
        quickSort(arr, j + 1, r);

    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }


}
