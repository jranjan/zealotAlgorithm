package org.zealot.algorithm.pattern.twopointers;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.twopointers.TargetSum;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TargetSumTest {
    @Test
    void targetSum() {
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int[] result = TargetSum.solution(nums, 6);
        assertTrue(result[0]==1 && result[1]==3);
        nums = new int[]{2, 5, 9, 11};
        result = TargetSum.solution(nums, 11);
        assertTrue(result[0]==0 && result[1]==2);
    }

    @Test
    void targetSumHashmap() {
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int[] result = TargetSum.solutionHashmap(nums, 6);
        assertTrue(result[0]==1 && result[1]==3);
        nums = new int[]{2, 5, 9, 11};
        result = TargetSum.solutionHashmap(nums, 11);
        assertTrue(result[0]==0 && result[1]==2);
    }
}
