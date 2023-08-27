package org.zealot.algorithm.pattern.xor;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.xor.FindMissingNumber;

public class FindMissingNumberTest {

    @Test
    void findMissingNumber(){
        int[] num1 = new int[]{1, 5, 2, 6, 4};
        System.out.println(FindMissingNumber.findMissingNumber(num1));
    }

}
