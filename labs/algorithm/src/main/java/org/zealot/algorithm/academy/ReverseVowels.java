package org.zealot.algorithm.academy;

import java.util.*;

public class ReverseVowels {
    public static String solution(String s) {
        List<Character> vowels = new ArrayList<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowels.add(ch);
            }
        }

        char[] chars = s.toCharArray();
        for(int i=0, j=vowels.size(); i<chars.length; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                chars[i] = vowels.get(j-1);
                j=j-1;
            }
        }

        return String.valueOf(chars);
    }

    public static String solutionBidirectionalMove(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        Boolean beginVowel = false;
        Boolean endVowel = false;
        while (begin < end) {
            // vowel from beginning
            while(!beginVowel) {
                char ch = chars[begin];
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    break;
                }
                begin = begin + 1;
            }

            // vowel from end
            while(!endVowel) {
                char ch = chars[end];
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    break;
                }
                end = end - 1;
            }

            // time to swap
            char swap = chars[begin];
            chars[begin] = chars[end];
            chars[end] = swap;

            begin = begin + 1;
            end = end - 1;
        }

        return String.valueOf(chars);
    }
}
