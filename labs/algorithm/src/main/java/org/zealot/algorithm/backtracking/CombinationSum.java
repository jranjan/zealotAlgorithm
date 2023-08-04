package org.zealot.algorithm.backtracking;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<candidates.length; i++){
            List<Integer> firstList = new ArrayList<>();
            firstList.add(candidates[i]);
            res.add(firstList);

            for(int j=0; j<candidates.length; j++){
                combinationSumElement(res, candidates[j], target);
            }
        }

        for(int i=0; i<res.size(); i++){
            Collections.sort(res.get(i));
        }

        // remove the unwanted
        Set<List<Integer>> newRes = new LinkedHashSet<>();
        for (int i =0; i < res.size(); i++) {
            List<Integer> l = res.get(i);

            int sum = 0;
            for(int j = 0; j < l.size(); j++) {
                sum = sum + l.get(j);
            }
            if (sum == target) {
                newRes.add(l);
            }
        }

        res.clear();
        res.addAll(newRes);
        return res;
    }

    public static void combinationSumElement(List<List<Integer>> listofList, int candidate, int target) {
        int size = listofList.size();
        for(int i=0; i<size; i++) {
            List<Integer> currList = listofList.get(i);

            // Get current sum
            int sum = 0;
            for(int n: currList){
                sum = sum + n;
            }

            // See if we can add the candidate N-times and get the result.
            // If we hit the bull then we add a new list.
            sum = sum + candidate;
            while(sum <= target) {
                if (sum == target) {
                    ArrayList newList = new ArrayList<>();
                    newList.addAll(currList);
                    newList.add(candidate);
                    listofList.add(newList);
                }

                sum = sum + candidate;
            }
        }
    }


    public static List<List<Integer>> combinationSumClean(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return  res;
    }

    // A recursive program which keeps track of current list and reduces sum as new element is added
    // Does it sound similar to what we did in previous exercise where we kept adding element by element
    // to exist element of lists to increase its size till we met a specific condition. The specific
    // condition is something nothing but target = zero (adjusted subtraction)
    public static void backtrack(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            // We added the valid combination
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                // Crossed the limit, move on
                // Candidates crosses the limit as candidate[i] + combinations > target
                continue;
            }

            // Add the element to combinations
            comb.add(candidates[i]);

            // Run backtrack to see if it can hit the base condition, if not then it will go deep further
            backtrack(candidates, i, target - candidates[i], comb, res);

            // If we are here, we hit all trials
            comb.remove(comb.size() - 1);
        }
    }
}
