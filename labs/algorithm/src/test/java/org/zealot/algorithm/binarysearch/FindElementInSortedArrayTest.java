package org.zealot.algorithm.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindElementInSortedArrayTest {
    @Test
    void find(){
        int[] num1 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num1) + ":" + FindElementInSortedArray.search(num1, 10));
        int[] num2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(num2) + ":" + FindElementInSortedArray.search(num2, 5));
        int[] num3 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(num3) + ":" + FindElementInSortedArray.search(num3, 3));
        int[] num4 = new int[]{10, 6, 4};
        System.out.println(Arrays.toString(num4) + ":" + FindElementInSortedArray.search(num4, 10));
        int[] num5 = new int[]{10, 6, 4};
        System.out.println(Arrays.toString(num5) + ":" + FindElementInSortedArray.search(num5, 4));
        int[] num6 = new int[]{500,400,300,200,100};
        System.out.println(Arrays.toString(num6) + ":" + FindElementInSortedArray.search(num6, 200));
        int[] num7 = new int[]{1,1,1,1,1};
        System.out.println(Arrays.toString(num7) + ":" + FindElementInSortedArray.search(num7, 1));
    }
}
