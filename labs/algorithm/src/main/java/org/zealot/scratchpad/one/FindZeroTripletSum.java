package org.zealot.scratchpad.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTripletSum {
    public static List<List<Integer>> tripletSearch(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        return triplets;
    }

    public static List<Integer> findTargetSum(int[] arr, int targetPos) {
        if ((targetPos < 0) || (targetPos >= arr.length)) return null;

        int targetSum = arr[targetPos];
        List<Integer> targetNumbersList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (i == targetPos) continue;

            int searchKey =  ;
            if (map.containsKey(searchKey)) {
                // Compliment is there, it means tht sum is going to be zero.
                targetNumbersList.add(arr[i]);
            } else {
                map.put(arr[i], i);
            }
        }

        return targetNumbersList;
    }
}
