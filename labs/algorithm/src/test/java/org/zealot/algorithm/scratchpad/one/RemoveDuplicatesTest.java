package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.RemoveDuplicates;

import java.util.Arrays;


public class RemoveDuplicatesTest {
    @Test
    void solution() {
        System.out.println("****** test count = 1");
        int[] num = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(String.format("Input=%s, Output=%s", Arrays.toString(num),
                RemoveDuplicates.erase(num)));
        num = new int[]{2, 2, 2, 11};
        System.out.println(String.format("Input=%s, Output=%s", Arrays.toString(num),
                RemoveDuplicates.erase(num)));
        num = new int[]{2, 3, 4, 5, 6, 9, 0};
        System.out.println(String.format("Input=%s, Output=%s", Arrays.toString(num),
                RemoveDuplicates.erase(num)));
    }

    @Test
    void solutionUsingSet() {
        System.out.println("****** test count = 2");
        int[] num = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(String.format("Input=%s, Output=%s", Arrays.toString(num),
                RemoveDuplicates.removeUsingSet(num)));
        num = new int[]{2, 2, 2, 11};
        System.out.println(String.format("Input=%s, Output=%s", Arrays.toString(num),
                RemoveDuplicates.removeUsingSet(num)));
        num = new int[]{2, 3, 4, 5, 6, 9, 0};
        System.out.println(String.format("Input=%s, Output=%s", Arrays.toString(num),
                RemoveDuplicates.removeUsingSet(num)));
    }
}
