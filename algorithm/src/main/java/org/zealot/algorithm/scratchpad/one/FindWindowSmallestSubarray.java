package org.zealot.algorithm.scratchpad.one;

import java.util.ArrayList;
import java.util.List;

public class FindWindowSmallestSubarray {
    public static int find(int[] num, int sum) {
        if (num.length == 0) return 0;

        int start = 0, smallest = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= sum) return 1;

            start = i;
            int currentSum = 0;
            for (int j = i; j < num.length; j++) {
                currentSum += num[j];
                if (currentSum >= sum) {
                    int newSize = j - start + 1;
                    if (smallest == 0) {
                        smallest = newSize;
                    } else {
                        smallest = Math.min(smallest, newSize);
                    }
                    break;
                }
            }
        }

        return smallest;
    }
}
