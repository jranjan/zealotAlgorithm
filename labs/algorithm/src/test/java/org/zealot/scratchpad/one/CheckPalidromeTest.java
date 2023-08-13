package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.warmup.Palidrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPalidromeTest {
    @Test
    void verify() {
        String s = "A man, a plan, a canal, Panama!";
        System.out.println(String.format("[%s] result = [%b]", s, CheckPalidrome.verify(s)));
        s = "Was $$ it ## a car or a @@ cat I saw?";
        System.out.println(String.format("[%s] result = [%b]", s, CheckPalidrome.verify(s)));
        s = "A man, a plan,a canal, Panama!";
        System.out.println(String.format("[%s] result = [%b]", s, CheckPalidrome.verify(s)));
        s = "1211314141 abccba";
        System.out.println(String.format("[%s] result = [%b]", s, CheckPalidrome.verify(s)));
    }
}
