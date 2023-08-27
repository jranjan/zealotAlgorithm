package org.zealot.algorithm.scratchpad.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BacktrackFindCombinationSum {

    public static List<List<Integer>> findTargetSum(int[] num, int target) {
        List<List<Integer>> l = new ArrayList<>();
        findTargetSum(num, 0, target, new ArrayList<>(), l);
        return l;
    }

    public static void findTargetSum(int[] num, int start, int target,
                                     List<Integer> possibilities, List<List<Integer>> l) {
        // Find the base condition of recursion! For us it is when target meets
        // to value equal to zero
        if (target == 0) {
            l.add(new ArrayList<>(possibilities));
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (num[i] > target) continue;
            possibilities.add(num[i]);
            findTargetSum(num, i, target - num[i], possibilities, l);
            possibilities.remove(possibilities.size() - 1);
        }
    }
}
