package org.zealot.algorithm.pattern.warmup;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.warmup.Sqrt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SqrtTest {

    @Test
    void sqrExact() {
        int number = 16;
        assertTrue(Sqrt.solution(number) == 4);
    }

    @Test
    void sqrRounded() {
        int number = 17;
        assertTrue(Sqrt.solution(number) == 4);
    }
}
