package org.zealot.algorithm.xor;

import org.junit.jupiter.api.Test;
import xor.TwoSingleNumber;

import java.util.Arrays;

public class TwoSingleNumberTest {
    @Test
    void twoSingleNumber(){
        int[] num1 = new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        System.out.println("Two number:" + Arrays.toString(TwoSingleNumber.single(num1)));
    }
}
