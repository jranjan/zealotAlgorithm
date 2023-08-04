package org.zealot.algorithm.kth;

import java.util.PriorityQueue;

public class KthSmallest {
    public static int findUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int i=0; i<nums.length; i++)
            minHeap.add(nums[i]);

        for(int i=0; i<k-1; i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static int findUsingMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        for (int i=0; i<k; i++)
            maxHeap.add(nums[i]);

        for(int i=k; i<nums.length; i++){
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();
    }
}
