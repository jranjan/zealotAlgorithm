package org.zealot.algorithm.pattern.xor;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.xor.SingleNumber;

public class SingleNumberTest {
    @Test
    void singleNumber(){
        int[] num1 = new int[]{1, 4, 2, 1, 3, 2, 3};
        System.out.println("Single number:" + SingleNumber.single(num1));
        int[] num2 = new int[]{7, 9, 7};
        System.out.println("Single number:" + SingleNumber.single(num2));
    }
}
