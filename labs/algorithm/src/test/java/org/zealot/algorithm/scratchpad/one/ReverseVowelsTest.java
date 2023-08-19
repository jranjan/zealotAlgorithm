package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.GetVowelsReversed;

public class ReverseVowelsTest {

    @Test
    void reverse1() {
        System.out.println("****** test count = 1");
        String s = "AEIOU";
        System.out.println(String.format("%s after algorithm is [%s]", s, GetVowelsReversed.algorithmLinearLoop(s)));
        s = "1U2O3I4E5A6";
        System.out.println(String.format("%s after algorithm is [%s]", s, GetVowelsReversed.algorithmLinearLoop(s)));
        s = "12131sfsfsfsf";
        System.out.println(String.format("%s after algorithm is [%s]", s, GetVowelsReversed.algorithmLinearLoop(s)));
    }

    @Test
    void reverse2() {
        System.out.println("****** test count = 2");
        String s = "AEIOU";
        System.out.println(String.format("%s after algorithm is [%s]", s, GetVowelsReversed.algorithmUsingBidirectionalPointers(s)));
        s = "1U2O3I4E5A6";
        System.out.println(String.format("%s after algorithm is [%s]", s, GetVowelsReversed.algorithmUsingBidirectionalPointers(s)));
        s = "12131sfsfsfsf";
        System.out.println(String.format("%s after algorithm is [%s]", s, GetVowelsReversed.algorithmUsingBidirectionalPointers(s)));
    }
}