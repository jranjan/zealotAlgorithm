package org.zealot.scratchpad.one;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class CheckPalidrome {
    public static boolean verify(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase().trim();
        for(int i = 0, j = s.length() - 1;  i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
