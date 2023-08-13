package org.zealot.scratchpad.one;

import java.util.*;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class FindSetOfLargestNumber {
    public static List<Integer> getLargestSet(int[] num, int k) {
        if (k > num.length) return null;

        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < num.length; i++) {
            pq.add(num[i]);
        }

        List<Integer> l = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            l.add(pq.poll());
        }

        return l;
    }

    public static List<Integer> getLargestSetUsingMinHeap(int[] num, int k) {
        if (k > num.length) return null;

        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < num.length; i++) {
            if (pq.size() < k) {
                pq.add(num[i]);
            } else {
                if (pq.peek() < num[i]) {
                    pq.poll();
                    pq.add(num[i]);
                }
            }
        }

        return new ArrayList(pq);
    }


}
