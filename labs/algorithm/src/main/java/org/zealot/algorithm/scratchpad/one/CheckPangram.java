package org.zealot.algorithm.scratchpad.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class CheckPangram {

    public static boolean algorithmUsingArray(String sentence) {
        sentence = sentence.toLowerCase();
        boolean[] alphabets = new boolean[26];
        for (Character ch : sentence.toCharArray()) {
            if ((ch >= 'a') && (ch <= 'z')){
                alphabets[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] != true)    {
                return false;
            }
        }

        return true;
    }

    public static boolean algorithmUsingSet(String sentence) {
        sentence = sentence.toLowerCase();
        Set<Character> s = new HashSet<>();
        for(Character ch : sentence.toCharArray()) {
            if ((ch >= 'a') && (ch <= 'z')) {
                s.add(ch);
            }
        }

        return (s.size() == 26) ? true : false;
    }
}
