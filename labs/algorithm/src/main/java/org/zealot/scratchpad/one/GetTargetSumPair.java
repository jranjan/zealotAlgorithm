package org.zealot.scratchpad.one;

import java.util.HashMap;
import java.util.Map;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class GetTargetSumPair {
    public static int[] search(int[] num, int targetSum) {
        int i = 0, j = num.length - 1;
        int[] elementIndex = new int[]{-1, -1};
        while(i < j) {
            int currentSum = num[i] + num[j];
            if (currentSum == targetSum) {
                elementIndex[0] = i;
                elementIndex[1] = j;
                return elementIndex;
            } else {
                if (currentSum > targetSum) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return elementIndex;
    }

    public static int[] searchUsingHashMap(int[] num, int target) {
        int[] targetIndex = new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i++) {
            int searchKey = target - num[i];
            if (map.containsKey(searchKey)) {
                // See if number exists then it means that we have found the compliment
                targetIndex[0] = map.get(searchKey);
                targetIndex[1] = i;
                return targetIndex;
            } else {
                // Store the compliment
                map.put(num[i], i);
            }
        }

        return targetIndex;
    }
}
