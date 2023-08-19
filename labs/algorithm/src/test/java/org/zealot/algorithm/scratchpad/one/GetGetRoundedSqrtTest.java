package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.GetRoundedSqrt;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetGetRoundedSqrtTest {

    @Test
    void sqrExact1() {
        int number = 16;
        System.out.println(String.format("Square root of %d is [%d]", number, GetRoundedSqrt.algorithmUsingLoop(number)));
        number = 17;
        System.out.println(String.format("Square root of %d is [%d]", number, GetRoundedSqrt.algorithmUsingLoop(number)));
        number = 0;
        System.out.println(String.format("Square root of %d is [%d]", number, GetRoundedSqrt.algorithmUsingLoop(number)));
    }

    @Test
    void sqrExact2() {
        int number = 16;
        System.out.println(String.format("Square root of %d is [%d]", number, GetRoundedSqrt.algorithimUsingBinarySearch(number)));
        number = 17;
        System.out.println(String.format("Square root of %d is [%d]", number, GetRoundedSqrt.algorithimUsingBinarySearch(number)));
        number = 0;
        System.out.println(String.format("Square root of %d is [%d]", number, GetRoundedSqrt.algorithimUsingBinarySearch(number)));
    }
}
