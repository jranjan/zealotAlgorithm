package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.slidingwindow.FindMaximumSumSubarray;

import java.util.Arrays;

public class FindWindowMaximumTest {
    @Test
    void findMaximum(){
        int[] num = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(String.format("Input=%s, k=%d, Maximum=%d",
                Arrays.toString(num), k, FindWindowMaximum.maximum(num, k)));

        num = new int[]{2, 3, 4, 1, 5};
        k = 2;
        System.out.println(String.format("Input=%s, k=%d, Maximum=%d",
                Arrays.toString(num), k, FindWindowMaximum.maximum(num, k)));
    }
}
