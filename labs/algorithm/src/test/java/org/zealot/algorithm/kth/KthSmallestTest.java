package org.zealot.algorithm.kth;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KthSmallestTest {
    @Test
    void findUsingMinHeap() {
        int[] nums1 = new int[]{1, 5, 12, 2, 11, 5};
        System.out.println("Input: " + Arrays.toString(nums1) + " Result using min heap: " + KthSmallest.findUsingMinHeap(nums1, 3));
        int[] nums2 = new int[]{1, 5, 12, 2, 11, 5};
        System.out.println("Input: " + Arrays.toString(nums2) + " Result using min heap:: " + KthSmallest.findUsingMinHeap(nums2, 4));
        int[] nums3 = new int[]{5, 12, 11, -1, 12};
        System.out.println("Input: " + Arrays.toString(nums3) + " Result using min heap:: " + KthSmallest.findUsingMinHeap(nums3, 3));
    }

    @Test
    void findUsingMaxHeap() {
        int[] nums1 = new int[]{1, 5, 12, 2, 11, 5};
        System.out.println("Input: " + Arrays.toString(nums1) + " Result using max heap: " + KthSmallest.findUsingMaxHeap(nums1, 3));
        int[] nums2 = new int[]{1, 5, 12, 2, 11, 5};
        System.out.println("Input: " + Arrays.toString(nums2) + " Result using max heap:: " + KthSmallest.findUsingMaxHeap(nums2, 4));
        int[] nums3 = new int[]{5, 12, 11, -1, 12};
        System.out.println("Input: " + Arrays.toString(nums3) + " Result using max heap:: " + KthSmallest.findUsingMaxHeap(nums3, 3));
    }
}
