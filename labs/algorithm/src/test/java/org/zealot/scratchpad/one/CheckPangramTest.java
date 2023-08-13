package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.warmup.Pangram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPangramTest {

    @Test
    void check1() {
        String sentence1 = "TheQuickBrownFoxJumpsOverTheLazyDog";
        System.out.println(String.format("%s test result=%b", sentence1, CheckPangram.algorithmUsingArray(sentence1)));

        String sentence2 = "Hello";
        System.out.println(String.format("%s test result=%b", sentence2, CheckPangram.algorithmUsingArray(sentence2)));

        String sentence3 = "TheQuickBrownFoxJumpsOewrwrwrw1242424242c  verTheLazyDog";
        System.out.println(String.format("%s test result=%b", sentence3, CheckPangram.algorithmUsingArray(sentence3)));
    }

    @Test
    void check2() {
        String sentence1 = "TheQuickBrownFoxJumpsOverTheLazyDog";
        System.out.println(String.format("%s test result=%b", sentence1, CheckPangram.algorithmUsingSet(sentence1)));

        String sentence2 = "Hello";
        System.out.println(String.format("%s test result=%b", sentence2, CheckPangram.algorithmUsingSet(sentence2)));

        String sentence3 = "TheQuickBrownFoxJumpsOewrwrwrw1242424242c  verTheLazyDog";
        System.out.println(String.format("%s test result=%b", sentence3, CheckPangram.algorithmUsingSet(sentence3)));
    }
}
