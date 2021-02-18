package sort;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 9, 2, 1, 6, 7, 3, 8, 4};

        bubbleSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }


    private static void bubbleSort(int[] arr) {

        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            bubble(arr);
        }
    }


    private static void bubble(int[] arr) {

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                swap(arr, i);
            }
        }


    }

    private static void swap(int[] arr, int i) {

        arr[i] = arr[i] ^ arr[i + 1];
        arr[i + 1] = arr[i] ^ arr[i + 1];
        arr[i] = arr[i] ^ arr[i + 1];
    }


}
