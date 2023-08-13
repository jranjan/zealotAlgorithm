package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.twopointers.TargetSum;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetTargetSumTest {
    @Test
    void solution() {
        System.out.println("******** test 1 ********");
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int targetSum = 6;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.search(nums, targetSum))));
        targetSum = 3;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.search(nums, targetSum))));
        targetSum = 99;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.search(nums, targetSum))));

        nums = new int[]{2, 5, 9, 11};
        targetSum = 11;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.search(nums, targetSum))));
    }

    @Test
    void solutionUsingMap() {
        System.out.println("******** test 2 ********");
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int targetSum = 6;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.searchUsingHashMap(nums, targetSum))));
        targetSum = 3;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.searchUsingHashMap(nums, targetSum))));
        targetSum = 99;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.searchUsingHashMap(nums, targetSum))));

        nums = new int[]{2, 5, 9, 11};
        targetSum = 11;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.searchUsingHashMap(nums, targetSum))));
        nums = new int[]{2, 2, 2, 2};
        targetSum = 4;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.searchUsingHashMap(nums, targetSum))));
        nums = new int[]{2, 2, 2, 2};
        targetSum = 6;
        System.out.println(String.format("Input=%s, target=%s, Result=%s", Arrays.toString(nums), targetSum,
                Arrays.toString(GetTargetSumPair.searchUsingHashMap(nums, targetSum))));
    }
}
