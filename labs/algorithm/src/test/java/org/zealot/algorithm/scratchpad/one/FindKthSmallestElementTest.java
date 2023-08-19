package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.FindKthSmallestElement;

import java.util.Arrays;

public class FindKthSmallestElementTest {
    @Test
    void test1() {
        System.out.println("****** test count = 1");
        int[] num = new int[]{1, 5, 12, 2, 11, 5};
        System.out.println(String.format("Input=%s, [%d]th smallest=%s",
                Arrays.toString(num), 3, FindKthSmallestElement.getSmallest(num, 3)));
        System.out.println(String.format("Input=%s, [%d]th smallest=%s",
                Arrays.toString(num), 4, FindKthSmallestElement.getSmallest(num, 3)));
        num = new int[]{5, 12, 11, -1, 12};
        System.out.println(String.format("Input=%s, [%d]th smallest=%s",
                Arrays.toString(num), -1, FindKthSmallestElement.getSmallest(num, -1)));
        System.out.println(String.format("Input=%s, [%d]th smallest=%s",
                Arrays.toString(num), 4, FindKthSmallestElement.getSmallest(num, 1)));
        System.out.println(String.format("Input=%s, [%d]th smallest=%s",
                Arrays.toString(num), 3, FindKthSmallestElement.getSmallest(num, 3)));
        System.out.println(String.format("Input=%s, [%d]th smallest=%s",
                Arrays.toString(num), 4, FindKthSmallestElement.getSmallest(num, 4)));
    }
}
