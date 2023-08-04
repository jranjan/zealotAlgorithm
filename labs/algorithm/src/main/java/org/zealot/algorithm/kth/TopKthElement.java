package org.zealot.algorithm.kth;

import org.zealot.ds.heap.HeapUtils;

import java.util.*;

public class TopKthElement {
    public static List<Integer> findKLargestNumbersBruteForce(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<k; i++) {
            list.add(nums[nums.length-i-1]);
        }
        return list;
    }

    public static List<Integer> findUsingHeapBruteForce(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int i=0;

        int[] newArr = Arrays.copyOf(nums, nums.length-i);
        while(i<k){
            HeapUtils.heapify(newArr);
            list.add(newArr[0]);
            newArr = HeapUtils.delete(newArr);
            i++;
        }

        return list;
    }

    public static List<Integer> findUsingHeapOptimal(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int i=0; i<k; i++)
            minHeap.add(nums[i]);

        for (int i=k; i<nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }

}
