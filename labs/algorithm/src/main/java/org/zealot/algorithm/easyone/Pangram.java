package org.zealot.algorithm.easyone;

import java.util.HashSet;
import java.util.Set;

// A pangram is a sentence where every letter of the English alphabet appears at least once.
// Given a string sentence containing English letters (lower or upper-case), return true if
// sentence is a pangram, or false otherwise.
public class Pangram {
    public static boolean solution(String sentence) {
        int smallBegin = 'a';
        int smallEnd = 'z';;
        int[] alphabets = new int[26];

        String sentenceLowerCase = sentence.toLowerCase();
        for(int i=0; i<sentenceLowerCase.length(); i++){
            int c = sentenceLowerCase.charAt(i);
            if ((c >= smallBegin) && (c <= smallEnd)) {
                int relativePosition = (int) sentenceLowerCase.charAt(i) - smallBegin;
                alphabets[relativePosition] = alphabets[relativePosition] + 1;
            }
        }

        for(int i=0; i<alphabets.length; i++) {
            if (alphabets[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean solutionHashset(String sentence) {
        Set<Character>s = new HashSet<>();

        for(char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                s.add(c);
            }
        }

        return (s.size() == 26) ? true : false;
    }
}
