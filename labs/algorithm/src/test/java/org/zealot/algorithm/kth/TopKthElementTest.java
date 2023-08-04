package org.zealot.algorithm.kth;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKthElementTest {
    @Test
    void findBruteForce() {
        int[] nums1 = new int[]{3, 1, 5, 12, 2, 11};
        System.out.println("Input: " + Arrays.toString(nums1) + " Brute force output: " + TopKthElement.findKLargestNumbersBruteForce(nums1, 3));
        int[] nums2 = new int[]{5, 12, 11, -1, 12};
        System.out.println("Input: " + Arrays.toString(nums2) + " Brute force output: " + TopKthElement.findKLargestNumbersBruteForce(nums2, 3));
    }

    @Test
    void findHeapBruteForce() {
        int[] nums1 = new int[]{3, 1, 5, 12, 2, 11};
        System.out.println("Input: " + Arrays.toString(nums1) + " Heapify brute force output: " + TopKthElement.findUsingHeapBruteForce(nums1, 3));
        int[] nums2 = new int[]{5, 12, 11, -1, 12};
        System.out.println("Input: " + Arrays.toString(nums2) + " Heapify brute force output: " + TopKthElement.findUsingHeapBruteForce(nums2, 3));
    }

    @Test
    void findHeapOptimal() {
        int[] nums1 = new int[]{3, 1, 5, 12, 2, 11};
        System.out.println("Input: " + Arrays.toString(nums1) + " Optimal heap output: " + TopKthElement.findUsingHeapOptimal(nums1, 3));
        int[] nums2 = new int[]{5, 12, 11, -1, 12};
        System.out.println("Input: " + Arrays.toString(nums2) + " Optimal heap output: " + TopKthElement.findUsingHeapOptimal(nums2, 3));
    }
}
