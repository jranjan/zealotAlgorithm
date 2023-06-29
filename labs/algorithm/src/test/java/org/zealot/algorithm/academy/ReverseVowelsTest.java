package org.zealot.algorithm.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseVowelsTest {

    @Test
    void reverseVowlesStringOnly() {
        String s = ReverseVowels.solution("AEIOU");
        assertTrue(s.equals("UOIEA"));
    }

    @Test
    void reverseMixedString() {
        String s = ReverseVowels.solution("1A2E3I4O5U6");
        assertTrue(s.equals("1U2O3I4E5A6"));
    }

    @Test
    void reverseZeroVowelString() {
        String s = ReverseVowels.solution("12131sfsfsfsf");
        assertTrue(s.equals("12131sfsfsfsf"));
    }

    @Test
    void reverseVowlesStringOnlyBidirectionalMethod() {
        String s = ReverseVowels.solution("AEIOU");
        assertTrue(s.equals("UOIEA"));
    }

    @Test
    void reverseMixedStringBidirectionalMethod() {
        String s = ReverseVowels.solution("1A2E3I4O5U6");
        assertTrue(s.equals("1U2O3I4E5A6"));
    }

    @Test
    void reverseZeroVowelStringBidirectionalMethod() {
        String s = ReverseVowels.solution("12131sfsfsfsf");
        assertTrue(s.equals("12131sfsfsfsf"));
    }
}