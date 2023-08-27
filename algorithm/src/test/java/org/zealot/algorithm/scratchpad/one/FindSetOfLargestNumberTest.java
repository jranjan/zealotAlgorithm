package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.FindSetOfLargestNumber;

import java.util.Arrays;

public class FindSetOfLargestNumberTest {
    @Test
    void test1() {
        System.out.println("****** test count = 1");
        int[] num = new int[]{3, 1, 5, 12, 2, 11};
        System.out.println(String.format("Input=%s, Output=%s",
                Arrays.toString(num), FindSetOfLargestNumber.getLargestSet(num, 3)));
        num = new int[]{5, 12, 11, -1, 12};
        System.out.println(String.format("Input=%s, Output=%s",
                Arrays.toString(num), FindSetOfLargestNumber.getLargestSet(num, 3)));
    }

    @Test
    void test2() {
        System.out.println("****** test count = 2");
        int[] num = new int[]{3, 1, 5, 12, 2, 11};
        System.out.println(String.format("Input=%s, Output=%s",
                Arrays.toString(num), FindSetOfLargestNumber.getLargestSetUsingMinHeap(num, 3)));
        num = new int[]{5, 12, 11, -1, 12};
        System.out.println(String.format("Input=%s, Output=%s",
                Arrays.toString(num), FindSetOfLargestNumber.getLargestSetUsingMinHeap(num, 3)));
    }
}
