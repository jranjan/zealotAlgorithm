package org.zealot.algorithm.easyone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PangramTest {

    @Test
    void pangram() {
        String sentence = "TheQuickBrownFoxJumpsOverTheLazyDog";
        assertTrue(Pangram.solution(sentence));
    }

    @Test
    void notPangram() {
        String sentence = "Hello";
        assertFalse(Pangram.solution(sentence));
    }

    @Test
    void pangramHashSet() {
        String sentence = "TheQuickBrownFoxJumpsOverTheLazyDog";
        assertTrue(Pangram.solutionHashset(sentence));
    }

    @Test
    void notPangramHashSet() {
        String sentence = "Hello";
        assertFalse(Pangram.solutionHashset(sentence));
    }
}
