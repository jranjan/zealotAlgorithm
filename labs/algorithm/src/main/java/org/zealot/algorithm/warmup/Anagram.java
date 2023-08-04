package org.zealot.algorithm.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static boolean solution(String s, String t) {
        char[] schars = s.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] tchars = t.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (schars.length != tchars.length) {
            return false;
        }

        Arrays.sort(schars);
        Arrays.sort(tchars);
        for(int i=0; i< schars.length; i++) {
            if (schars[i] != tchars[i]) {
                    return false;
            }
        }

        return true;
    }


    public static boolean solutionHashmap(String s, String t) {
        s = s.replaceAll("\\s", "").toLowerCase();
        t = t.replaceAll("\\s", "").toLowerCase();

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        ArrayList<Integer> values = new ArrayList<Integer>(freqMap.values());
        for(Integer v : values) {
            if (v != 0) {
                return false;
            }
        }

        return  true;
    }
}
