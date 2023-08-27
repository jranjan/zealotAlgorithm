package org.zealot.algorithm.scratchpad.one;

import java.util.*;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REVISIT
 *****************************************************************************************************/
public class GetGoodPair {
    public int find(int[] nums) {
        int total = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(Integer k : map.keySet()) {
            Integer n = map.get(k) * (map.get(k) - 1) / 2;
            total = total + n;
        }
        return total;
    }

    public class PairInfo {
        int pos;
        List<Integer> peers = new ArrayList<>();
    }
}
