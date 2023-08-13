package org.zealot.scratchpad.one;

import java.util.*;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = CRAWL | HIGH | EXCELLENT | UGLY | MEMORISE
 *****************************************************************************************************/
public class FindZeroTripletSum {
    public static List<List<Integer>> tripletSearch(int[] arr) {
        Set<List<Integer>> tripletsSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<List<Integer>> s = findTripletList(arr, i);
            tripletsSet.addAll(s);
        }

        List<List<Integer>> triplets = new ArrayList<>();
        triplets.addAll(tripletsSet);
        return triplets;
    }

    public static Set<List<Integer>> findTripletList(int[] arr, int targetPos) {
        if ((targetPos < 0) || (targetPos >= arr.length)) return null;

        Map<Integer, Integer> map = new HashMap();
        Set<List<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == targetPos) continue;
            int searchKey = - arr[targetPos] - arr[i];
            if (map.containsKey(searchKey)) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[targetPos]);
                l.add(arr[i]);
                l.add(searchKey);
                Collections.sort(l);
                triplets.add(l);
            } else {
                map.put(arr[i], i);
            }
        }

        return triplets;
    }
}
