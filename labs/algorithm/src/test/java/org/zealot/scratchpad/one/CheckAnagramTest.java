package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.warmup.Anagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckAnagramTest {

    @Test
    void verify() {
        String s = "listen", t = "silent";
        System.out.println(String.format("[%s] is anagram of [%s]? RESULT=[%b]", s, t, CheckAnagram.verify(s, t)));
        s = "a gentleman"; t = "elegant man";
        System.out.println(String.format("[%s] is anagram of [%s]? RESULT=[%b]", s, t, CheckAnagram.verify(s, t)));
        s = "rat"; t = "car";
        System.out.println(String.format("[%s] is anagram of [%s]? RESULT=[%b]", s, t, CheckAnagram.verify(s, t)));
        s = "hello"; t = "world";
        System.out.println(String.format("[%s] is anagram of [%s]? RESULT=[%b]", s, t, CheckAnagram.verify(s, t)));
    }
}
