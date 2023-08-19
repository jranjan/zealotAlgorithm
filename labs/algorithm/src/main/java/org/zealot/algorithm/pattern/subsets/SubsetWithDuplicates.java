package org.zealot.algorithm.pattern.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> distinctSubset = new ArrayList<List<Integer>>();
        distinctSubset.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            int size = distinctSubset.size();
            for(int j=0; j<size; j++){
                List<Integer> nl = new ArrayList<Integer>();
                nl.addAll(distinctSubset.get(j));
                nl.add(nums[i]);
                if (checkDuplicate(distinctSubset, nl) == false) {
                    distinctSubset.add(nl);
                }
            }
        }
        return distinctSubset;
    }

    private static boolean checkDuplicate(List<List<Integer>> subsets, List<Integer> element) {
        for(int i=0; i<subsets.size(); i++) {
            if (element.equals(subsets.get(i))) {
                return true;
            }
        }

        return false;
    }

    // The algorithm works but I still did not understand how sorting and considering
    // only last subset helps. For now, I will keep ruminating about this.
    public static List<List<Integer>> findSubsetsSmartway(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> distinctSubset = new ArrayList<List<Integer>>();
        distinctSubset.add(new ArrayList<>());

        // Instead of copy entire list, we decided to track pointer (i.e. index). As we add list,
        // we need to track of sliding window i.e. portion of list which is recently added. Why
        // did not my brain think of tracking instead of just copying and so on with brut force.
        // Shh! It looks ugly to think. Always remember sliding window.

        // To start with we have window with only one element
        int startIndex = 0, endIndex = 0;
        for(int i=0; i<nums.length; i++) {
            // Reset start index, which will always be zero unless need to change because of duplciate
            // element in the list.
            startIndex = 0;

            if (i > 0 && nums[i] == nums[i - 1]) {
                // Hit duplicate, time to chnage the window before we add anything.
                // New start becomes our last subsets first element.
                startIndex = endIndex + 1;
            }

            // We do not want to iterate more than this, isn't it? Its always an upper bound.
            endIndex = distinctSubset.size() - 1;
            for(int j = startIndex; j <= endIndex; j++){
                List<Integer> set = new ArrayList<>(distinctSubset.get(j));
                set.add(nums[i]);
                distinctSubset.add(set);
            }
        }
        return distinctSubset;
    }
}
