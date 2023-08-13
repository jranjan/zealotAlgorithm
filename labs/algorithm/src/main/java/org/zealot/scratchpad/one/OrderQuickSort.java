package org.zealot.scratchpad.one;

public class OrderQuickSort {
    public static void sort(int[] num) {
        if ((num.length == 0) || (num.length == 1)) return;
        quickSort(num, 0, num.length - 1);
    }

    public static void quickSort(int[] num, int low, int high) {
        if (low < high) {
            int pivot = partition(num, low, high);
            quickSort(num, low, pivot - 1);
            quickSort(num, pivot, high);
        }
    }
    public static int partition(int[] num, int low, int high) {
        // let us choose the pivot
        int pivot = num[high];

        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (num[j] < pivot) {
                i++;
                swap(num, i, j);
            }
        }

        swap(num, i + 1, high);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
