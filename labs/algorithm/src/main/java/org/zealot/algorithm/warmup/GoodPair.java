package org.zealot.algorithm.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GoodPair {
    public static int solution(int[] nums) {
        ArrayList<String> goodPairs = new ArrayList<>();
        Arrays.sort(nums);

       for(int i=0; i< nums.length; i++) {
            for(int j=i+1; j<nums.length; j++){
                if (nums[i] != nums[j]) {
                    break;
                }
                goodPairs.add(String.format("%d:%d", nums[i], nums[j]));
            }
        }

        return goodPairs.size();
    }

    public static int solutionWithoutSort(int[] nums) {
        ArrayList<String> goodPairs = new ArrayList<>();

        for(int i=0; i< nums.length; i++) {
            for(int j=i+1; j<nums.length; j++){
                if (nums[i] == nums[j]) {
                    goodPairs.add(String.format("%d:%d", nums[i], nums[j]));
                }
            }
        }

        return goodPairs.size();
    }

    public static int solutionHashmap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int pairCount = 0;
        for(int k : map.keySet()) {
            pairCount = pairCount + (map.get(k) * (map.get(k) - 1))/2;
        }
        return pairCount;
    }
}

