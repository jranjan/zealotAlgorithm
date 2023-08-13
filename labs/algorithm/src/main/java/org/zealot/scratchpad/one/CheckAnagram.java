package org.zealot.scratchpad.one;

import java.util.HashMap;
import java.util.Map;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class CheckAnagram {
    public static boolean verify(String s, String t){
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for(int j = 0; j < t.length(); j++) {
            Character ch = t.charAt(j);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }

        return (map.size() == 0) ? true : false;
    }
}
