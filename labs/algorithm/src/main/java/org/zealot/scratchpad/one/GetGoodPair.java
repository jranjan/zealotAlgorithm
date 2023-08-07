package org.zealot.scratchpad.one;

import java.util.*;

public class GetGoodPair {
    public int find(int[] nums) {
        Map<Integer, PairInfo> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                PairInfo pairInfo = map.get(nums[i]);
                pairInfo.peers.add(i);
            } else {
                PairInfo pairInfo = new PairInfo();
                pairInfo.pos = i;
                map.put(nums[i], pairInfo);
            }
        }

        int total = 0;
        for(Integer k : map.keySet()) {
            PairInfo pairInfo = map.get(k);
            total = total + pairInfo.peers.size();
        }

        return total;
    }

    public class PairInfo {
        int pos;
        List<Integer> peers = new ArrayList<>();
    }
}
