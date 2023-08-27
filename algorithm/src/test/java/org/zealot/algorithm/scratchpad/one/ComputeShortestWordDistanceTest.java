package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.ComputeShortestWordDistance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputeShortestWordDistanceTest {
    @Test
    void checkDistance() {
        String[] words = new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word1 = "fox", word2 = "dog";
        System.out.println(("Word set=%s, word1=%s, word2=%s, shortest " +
                "distance = %d").format(Arrays.toString(words), word1, word2,
                ComputeShortestWordDistance.compute(words, word1, word2)));

        words = new String[]{"a", "c", "d", "b", "a"};
        word1 = "a"; word2 = "b";
        System.out.println(("Word set=%s, word1=%s, word2=%s, shortest " +
                "distance = %d").format(Arrays.toString(words), word1, word2,
                ComputeShortestWordDistance.compute(words, word1, word2)));
    }
}
