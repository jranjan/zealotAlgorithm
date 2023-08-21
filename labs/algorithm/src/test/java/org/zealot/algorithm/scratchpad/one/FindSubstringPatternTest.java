package org.zealot.algorithm.scratchpad.one;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FindSubstringPatternTest {
  @Test
  void findWindow() {
    String s = "ADOBECODEBANC";
    String t = "ABC";

    System.out.println(String.format("Source[%s], Target=[%s], Result=[%b]",
        s, t, FindSubstringPattern.findPatternExistence(s, t)));

    t = "ABCB";
    System.out.println(String.format("Source[%s], Target=[%s], Result=[%b]",
        s, t, FindSubstringPattern.findPatternExistence(s, t)));


    t = "ABCBB";
    System.out.println(String.format("Source[%s], Target=[%s], Result=[%b]",
        s, t, FindSubstringPattern.findPatternExistence(s, t)));
  }
}
