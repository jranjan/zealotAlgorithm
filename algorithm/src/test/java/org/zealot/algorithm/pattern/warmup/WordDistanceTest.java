package org.zealot.algorithm.pattern.warmup;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.warmup.WordDistance;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordDistanceTest {
    @Test
    void checkDistance() {
        String[] wordSet1 = new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        assertTrue(WordDistance.solution(wordSet1, "fox", "dog") == 5);
        assertTrue(WordDistance.solution(wordSet1, "fox", "fox") == 0);
        String[] wordSet2 = new String[]{"a", "c", "d", "b", "a"};
        assertTrue(WordDistance.solution(wordSet2, "a", "b") == 1);
        String[] wordSet3 = new String[]{"a", "c", "b", "d", "b", "a"};
        assertTrue(WordDistance.solutionBirdirectionalPointer(wordSet3, "a", "b") == 1);
    }

    @Test
    void checkDistanceBirdirectionalPointer() {
        String[] wordSet1 = new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        assertTrue(WordDistance.solutionBirdirectionalPointer(wordSet1, "fox", "dog") == 5);
        assertTrue(WordDistance.solutionBirdirectionalPointer(wordSet1, "fox", "fox") == 0);
        String[] wordSet2 = new String[]{"a", "c", "d", "b", "a"};
        assertTrue(WordDistance.solutionBirdirectionalPointer(wordSet2, "a", "b") == 1);
        String[] wordSet3 = new String[]{"a", "c", "b", "d", "b", "a"};
        assertTrue(WordDistance.solutionBirdirectionalPointer(wordSet3, "a", "b") == 1);
    }
}
