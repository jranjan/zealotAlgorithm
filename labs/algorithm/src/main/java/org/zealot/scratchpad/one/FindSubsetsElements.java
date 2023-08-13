package org.zealot.scratchpad.one;

import java.util.*;


/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | UGLY | REVISIT
 *****************************************************************************************************/
public class FindSubsetsElements {
    public static List<List<Integer>> findAll(int[] num) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(Collections.emptyList());
        int start = 0, end = 0;

        for (int i = 0; i < num.length; i++) {

            if ((i > 0) && (num[i-1] == num[i])) {
                start = end + 1;
            } else {
                start = 0;
            }

            end = subsets.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> nl = new ArrayList<>(subsets.get(j));
                nl.add(num[i]);
                subsets.add(nl);
            }
        }

        return subsets;
    }
}
