package org.zealot.algorithm.pattern.slidingwindow;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.slidingwindow.FindMaximumSumSubarray;

public class FindMaximumSumSubarrayTest {
    @Test
    void findMaximum(){
        int[] nums1 = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(FindMaximumSumSubarray.findMaximum(3, nums1));
        int[] nums2 = new int[]{2, 3, 4, 1, 5};
        System.out.println(FindMaximumSumSubarray.findMaximum(2, nums2));
    }
}
