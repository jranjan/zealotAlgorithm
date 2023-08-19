package org.zealot.algorithm.pattern.warmup;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.warmup.ContainsDuplicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTest {

    @Test
    void zeroDuplicate() {
        int[] numbers = { 1, 2, 3, 4};
        assertFalse(ContainsDuplicate.solution(numbers));
    }

    @Test
    void duplicate() {
        int[] numbers = { 1, 2, 3, 4, 4, 5};
        assertTrue(ContainsDuplicate.solution(numbers));
    }

    @Test
    void zeroDuplicateSetSolution() {
        int[] numbers = { 1, 2, 3, 4};
        assertFalse(ContainsDuplicate.solutionUsingSet(numbers));
    }

    @Test
    void duplicateSetSolution() {
        int[] numbers = { 1, 2, 3, 4, 4, 5};
        assertTrue(ContainsDuplicate.solutionUsingSet(numbers));
    }

    @Test
    void zeroDuplicateSortArraySolution() {
        int[] numbers = { 1, 2, 3, 4};
        assertFalse(ContainsDuplicate.solutionSortArray(numbers));
    }

    @Test
    void duplicateSortArraySolution() {
        int[] numbers = { 1, 2, 3, 4, 4, 5};
        assertTrue(ContainsDuplicate.solutionSortArray(numbers));
    }
}
