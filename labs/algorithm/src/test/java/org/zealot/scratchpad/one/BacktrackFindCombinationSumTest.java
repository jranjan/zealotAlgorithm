package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.backtracking.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackFindCombinationSumTest {
    @Test
    void combinationSum() {
        int[] num = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(String.format("Input=%s, target=%d, result=%s", Arrays.toString(num),
                target, BacktrackFindCombinationSum.findTargetSum(num, target)));

        num = new int[]{2, 4, 6, 8};
        target = 10;
        System.out.println(String.format("Input=%s, target=%d, result=%s", Arrays.toString(num),
                target, BacktrackFindCombinationSum.findTargetSum(num, target)));
    }
}
