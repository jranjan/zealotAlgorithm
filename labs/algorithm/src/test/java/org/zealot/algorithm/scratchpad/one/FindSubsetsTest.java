package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.FindSubsetsElements;

import java.util.Arrays;

public class FindSubsetsTest {
    @Test
    void findSubsets() {
        int[] num = new int[]{1, 3, 3};
        System.out.println(String.format("Input=%s, Subsets=%s", Arrays.toString(num),
                FindSubsetsElements.findAll(num)));

        num = new int[]{1, 5, 3, 3};
        System.out.println(String.format("Input=%s, Subsets=%s", Arrays.toString(num),
                FindSubsetsElements.findAll(num)));
    }
}
