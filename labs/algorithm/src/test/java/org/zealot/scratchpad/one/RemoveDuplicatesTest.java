package org.zealot.algorithm.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveDuplicatesTest {
    @Test
    void containsDuplicates() {
        int[] num = new int[]{2, 3, 3, 3, 6, 9, 9};
        assertTrue(RemoveDuplicates.solution(num) == 4);
        num = new int[]{2, 2, 2, 11};
        assertTrue(RemoveDuplicates.solution(num) == 2);
    }

    @Test
    void containsZeroDuplicates() {
        int[] num = new int[]{2, 3, 4, 5, 6, 9, 0};
        assertTrue(RemoveDuplicates.solution(num) == 7);
    }
}
