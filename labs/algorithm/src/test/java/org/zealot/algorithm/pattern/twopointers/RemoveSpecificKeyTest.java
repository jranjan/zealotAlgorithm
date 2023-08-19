package org.zealot.algorithm.pattern.twopointers;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.twopointers.RemoveSpecificKey;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveSpecificKeyTest {
    @Test
    void removeExistingKey() {
        int[] nums = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        assertTrue(RemoveSpecificKey.solution(nums, 3) == 4);
        nums = new int[]{2, 11, 2, 2, 1};
        assertTrue(RemoveSpecificKey.solution(nums, 2) == 2);
    }

    @Test
    void removeMissingKey() {
        int[] nums = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        assertTrue(RemoveSpecificKey.solution(nums, 11) == 8);
    }
}
