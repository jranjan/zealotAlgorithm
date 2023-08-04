package org.zealot.algorithm.warmup;

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
