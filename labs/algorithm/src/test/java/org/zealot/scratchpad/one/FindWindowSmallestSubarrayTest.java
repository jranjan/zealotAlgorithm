package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindWindowSmallestSubarrayTest {
    @Test
    void find() {
        int[] num = new int[]{2, 1, 5, 2, 3, 2};
        int sum = 7;
        System.out.println(String.format("Input=%s, sum=%d, count=%d",
                Arrays.toString(num), sum, FindWindowSmallestSubarray.find(num, sum)));
        sum = 15;
        System.out.println(String.format("Input=%s, sum=%d, count=%d",
                Arrays.toString(num), sum, FindWindowSmallestSubarray.find(num, sum)));
        sum = 2;
        System.out.println(String.format("Input=%s, sum=%d, count=%d",
                Arrays.toString(num), sum, FindWindowSmallestSubarray.find(num, sum)));

        num = new int[]{2, 1, 5, 2, 8};
        sum = 7;
        System.out.println(String.format("Input=%s, sum=%d, count=%d",
                Arrays.toString(num), sum, FindWindowSmallestSubarray.find(num, sum)));

    }
}
