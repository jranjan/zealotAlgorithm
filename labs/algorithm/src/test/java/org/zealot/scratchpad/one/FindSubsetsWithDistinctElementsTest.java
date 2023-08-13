package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindSubsetsWithDistinctElementsTest {
    @Test
    void findSubsets() {
        int[] num = new int[]{1, 5, 3};
        System.out.println(String.format("Input=%s, Subsets=%s", Arrays.toString(num),
                FindSubsetsWithDistinctElements.findAll(num)));
    }
}
