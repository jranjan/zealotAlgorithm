package org.zealot.scratchpad.one;

import java.util.LinkedHashSet;
import java.util.Set;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class RemoveDuplicates {
    public static int erase(int[] num) {
        int startPos = 0;
        int movingStartPos = 0;
        for(int i = 1; i < num.length; i++) {
            if (num[i] == num[movingStartPos]) {
                movingStartPos++;
            } else {
                // time to move the element to new position
                num[startPos] = num[i];
                // adjust the start position as we need to find new place
                startPos++;
                // setup new position pointers
                movingStartPos = i;
            }
        }

        return startPos + 1;
    }

    public static int removeUsingSet(int[] num){
        Set<Integer> s = new LinkedHashSet<>();
        for(int i = 0; i < num.length; i++) {
            s.add(num[i]);
        }
        return s.size();
    }
}
