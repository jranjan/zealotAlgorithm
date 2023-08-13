package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OrderQuickSortTest {
    @Test
    void sort() {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println(String.format("Input=%s", Arrays.toString(arr)));
        OrderQuickSort.sort(arr);
        System.out.println(String.format("Sorted output=%s", Arrays.toString(arr)));
    }
}
