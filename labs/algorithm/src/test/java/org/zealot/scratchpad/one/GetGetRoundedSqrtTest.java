package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.warmup.Sqrt;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetSqrtTest {

    @Test
    void sqrExact() {
        int number = 16;
        System.out.println(String.format("Square root of %d is [%d]", number, GetSqrt.algorithmUsingLoop(number)));
        number = 17;
        System.out.println(String.format("Square root of %d is [%d]", number, GetSqrt.algorithmUsingLoop(number)));
        number = 0;
        System.out.println(String.format("Square root of %d is [%d]", number, GetSqrt.algorithmUsingLoop(number)));
    }
}
