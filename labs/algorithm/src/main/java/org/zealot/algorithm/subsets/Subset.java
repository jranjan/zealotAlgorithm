package org.zealot.algorithm.subsets;

import java.util.*;

public class Subset {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(Collections.emptyList());
        for(int i=0; i<nums.length; i++){
            int fixedSize = subsets.size();
            for(int j=0; j<fixedSize; j++) {
                ArrayList<Integer> nl = new ArrayList<>();
                nl.addAll(subsets.get(j));
                nl.add(nums[i]);
                subsets.add(nl);
            }
        }
        return subsets;
    }


}
