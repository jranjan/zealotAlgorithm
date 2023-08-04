package org.zealot.algorithm.cyclicsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {
    @Test
    void Sort() {
        int[] nums1 = new int[]{3, 1, 5, 4, 2};
        System.out.println(Arrays.toString(Sort.sort(nums1)));
        System.out.println("-------------------------");
        int[] nums2 = new int[]{2, 6, 4, 3, 1, 5};
        System.out.println(Arrays.toString(Sort.sort(nums2)));
        System.out.println("-------------------------");
        int[] nums3 = new int[]{1, 5, 6, 4, 3, 2};
        System.out.println(Arrays.toString(Sort.sort(nums3)));
        System.out.println("-------------------------");
    }
}
