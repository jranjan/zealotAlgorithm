package org.zealot.algorithm.pattern.slidingwindow;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.slidingwindow.FindSumOfGivenElementCount;

import java.util.Arrays;

public class FindSumOfGivenElementCountTest {
    @Test
    void findAveragesBruteForuce(){
        int[] nums = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] result = FindSumOfGivenElementCount.findAveragesBruteForce(5, nums);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void findAveragesSlidingWindowNaive(){
        int[] nums = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] result = FindSumOfGivenElementCount.findAveragesSlidingWindowNaive(5, nums);
        System.out.println(Arrays.toString(result));

    }

    @Test
    void findAveragesSlidingWindow(){
        int[] nums = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] result = FindSumOfGivenElementCount.findAveragesSlidingWindow(5, nums);
        System.out.println(Arrays.toString(result));
    }
}
