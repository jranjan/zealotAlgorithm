package org.zealot.algorithm.scratchpad.one;

import java.util.*;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | UGLY | REVISIT
 *****************************************************************************************************/
public class FindSubsetsWithDistinctElements {
    public static List<List<Integer>> findAll(int[] num) {
        List<List<Integer>> subsets = new LinkedList<>();
        subsets.add(Collections.emptyList());
        for (int i = 0; i < num.length; i++) {
            int currSize = subsets.size();
            for (int j = 0; j < currSize; j++) {
                List<Integer> cl = new ArrayList<>();
                cl.addAll(subsets.get(j));
                cl.add(num[i]);
                subsets.add(cl);
            }
        }
        return subsets;
    }
}
