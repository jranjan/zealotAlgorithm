package org.zealot.algorithm.scratchpad.one;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class FindKthSmallestElement {
    public static int getSmallest(int[] nums, int k) {
        if (k <= 0) return -1;
        if (k > nums.length) return -1;

        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.add(nums[i]);
            } else {
                if (pq.peek() > nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }

        return pq.peek();
    }
}
