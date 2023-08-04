package org.zealot.algorithm.warmup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalidromeTest {
    @Test
    void itsPalidrome() {
        String s = "A man, a plan, a canal, Panama!";
        assertTrue(Palidrome.solution(s));
        s = "Was it a car or a cat I saw?";
        assertTrue(Palidrome.solution(s));
    }
    @Test
    void itsPalidromeNonAlphanumeric() {
        String s = "A man, a plan,a canal, Panama!";
        assertTrue(Palidrome.solution(s));
        s = "Was $$ it ## a car or a @@ cat I saw?";
        assertTrue(Palidrome.solution(s));
    }

    @Test
    void itsNotPalidrome() {
        String s = "1211314141 abccba";
        assertFalse(Palidrome.solution(s));
    }
}
