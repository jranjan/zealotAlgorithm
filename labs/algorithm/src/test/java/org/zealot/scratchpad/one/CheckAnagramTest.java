package org.zealot.algorithm.warmup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramTest {

    @Test
    void anagram() {
        assertTrue(Anagram.solution("listen", "silent"));
        assertTrue(Anagram.solution("a gentleman", "elegant man"));
    }

    @Test
    void anagramNot() {
        assertFalse(Anagram.solution("rat", "car"));
        assertFalse(Anagram.solution("hello", "world"));
    }

    @Test
    void anagramHashmap() {
        assertTrue(Anagram.solutionHashmap("listen", "silent"));
        assertTrue(Anagram.solutionHashmap("a gentleman", "elegant man"));
    }

    @Test
    void anagramHashmapNot() {
        assertFalse(Anagram.solutionHashmap("rat", "car"));
        assertFalse(Anagram.solutionHashmap("hello", "world"));
    }
}
