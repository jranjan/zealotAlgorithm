package org.zealot.algorithm.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

public class SubsetTest {
    @Test
    void findSubsets() {
        int[] num1 = new int[]{1, 5, 3};
        System.out.println(Subset.findSubsets(num1).toString());
    }
}
