package org.zealot.algorithm.scratchpad.one;

import java.util.HashMap;
import java.util.Map;

public class FindSubstringPattern {
  public static boolean findPatternExistence(String s, String t) {
    Map<Character, Integer> map1 = new HashMap<>();

    // Store the frequency of each character
    for (int i = 0; i < t.length(); i++) {
      Character ch = t.charAt(i);
      if (map1.containsKey(ch)) {
        map1.put(ch, map1.get(ch) + 1);
      } else {
        map1.put(ch, 1);
      }
    }

    // Store the frequency of each character
    Map<Character, Integer> map2 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      if (map2.containsKey(ch)) {
        map2.put(ch, map2.get(ch) + 1);
      } else {
        map2.put(ch, 1);
      }
    }

    for (Character k : map1.keySet()) {
      int tc = map1.get(k);
      if (!map2.containsKey(k)) {
        return false;
      } else {
        int sc = map2.get(k);
        if (sc < tc) {
          return false;
        }
      }
    }

    return true;
  }
}
