package org.zealot.algorithm.academy;

import static java.lang.Character.SPACE_SEPARATOR;

public class Palidrome {
    public static boolean solution(String s) {
        boolean result = true;
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] chars = s.toLowerCase().toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin++ < end--) {
            if (chars[begin] != chars[end]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
