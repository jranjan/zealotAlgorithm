package org.zealot.algorithm.scratchpad.one;

import java.util.*;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class GetVowelsReversed {
    public static String algorithmLinearLoop(String s){
        char[] charArray = s.toCharArray();
        List<Integer> positions = new LinkedList<>();
        List<Character> vowels = new LinkedList<>();
        for(int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (((ch == 'a') || (ch == 'A')) || ((ch == 'e') || (ch == 'E')) || ((ch == 'i') || (ch == 'I')) ||
                    ((ch == 'o') || (ch == 'O')) || ((ch == 'u') || (ch == 'U'))){
                positions.add(i);
                vowels.add(ch);
            }
        }

        for(int j = 0; j < positions.size(); j++) {
            int currPos = positions.get(j);
            charArray[currPos] = vowels.get(vowels.size() - j - 1);
        }

        return new String(charArray);
    }

    public static String algorithmUsingBidirectionalPointers(String s){
        int leftPos = 0;
        int rightPos = s.length() - 1;
        char[] charArray = s.toCharArray();
        while(leftPos < rightPos) {
            // Move the left position till we add a vowel
            while (leftPos < s.length()) {
                char ch = s.charAt(leftPos);
                if (((ch == 'a') || (ch == 'A')) || ((ch == 'e') || (ch == 'E')) || ((ch == 'i') || (ch == 'I')) ||
                        ((ch == 'o') || (ch == 'O')) || ((ch == 'u') || (ch == 'U'))) {
                    break;
                }
                leftPos++;
            }

            // Move the right position till we add a vowel
            while (rightPos >= 0) {
                char ch = s.charAt(rightPos);
                if (((ch == 'a') || (ch == 'A')) || ((ch == 'e') || (ch == 'E')) || ((ch == 'i') || (ch == 'I')) ||
                        ((ch == 'o') || (ch == 'O')) || ((ch == 'u') || (ch == 'U'))) {
                    break;
                }
                rightPos--;
            }

            // Swap the elements
            if ((leftPos < s.length()) && (rightPos >= 0)) {
                charArray[leftPos] = s.charAt(rightPos);
                charArray[rightPos] = s.charAt(leftPos);
                leftPos++;
                rightPos--;
            }
        }

        return new String(charArray);
    }
}
