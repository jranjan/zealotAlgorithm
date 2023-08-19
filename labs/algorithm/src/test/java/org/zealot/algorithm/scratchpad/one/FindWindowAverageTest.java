package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.FindWindowAverage;

import java.util.Arrays;

public class FindWindowAverageTest {
    @Test
    void average(){
        int[] num = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(String.format("Input=%s, K=%d, Output average=%s",
                Arrays.toString(num), k, Arrays.toString(FindWindowAverage.average(num, k))));
    }
}
