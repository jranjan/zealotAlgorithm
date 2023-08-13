package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.scratchpad.one.CheckArrayDuplicates;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckArrayDuplicatesTest {

    @Test
    void checkDuplicates() {
        int[] num1 = {1, 2, 3, 4};
        assertFalse(CheckArrayDuplicates.algorithmUsingSet(num1));
        int[] num2 = {1, 2, 3, 1};
        assertTrue(CheckArrayDuplicates.algorithmUsingSet(num2));
        int[] num3 = {};
        assertFalse(CheckArrayDuplicates.algorithmUsingSet(num3));
    }

}
