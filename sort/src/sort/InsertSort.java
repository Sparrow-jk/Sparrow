package sort;

/**
 * @author Sparrow
 */
public class InsertSort {


    public static void main(String[] args) {

        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        insertSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }

    private static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            insert(arr, i);
        }

    }

    private static void insert(int[] arr, int n) {

        int i = n;
        int key = arr[n];
        while (key < arr[i - 1]) {
            arr[i] = arr[i - 1];
            i--;
            if (i == 0) {
                break;
            }
        }
        arr[i] = key;
    }
}
