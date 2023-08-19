package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.FindSubsetsWithDistinctElements;

import java.util.Arrays;

public class FindSubsetsWithDistinctElementsTest {
    @Test
    void findSubsets() {
        int[] num = new int[]{1, 5, 3};
        System.out.println(String.format("Input=%s, Subsets=%s", Arrays.toString(num),
                FindSubsetsWithDistinctElements.findAll(num)));
    }
}
