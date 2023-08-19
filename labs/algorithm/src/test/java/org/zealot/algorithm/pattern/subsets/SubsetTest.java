package org.zealot.algorithm.pattern.subsets;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.subsets.Subset;

public class SubsetTest {
    @Test
    void findSubsets() {
        int[] num1 = new int[]{1, 5, 3};
        System.out.println(Subset.findSubsets(num1).toString());
    }
}
