package org.zealot.scratchpad.one;

import java.util.HashSet;
import java.util.Set;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REFRESH
 *****************************************************************************************************/
public class CheckArrayDuplicates {
    public static boolean algorithmUsingSet(int[] numbers) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            if (s.add(numbers[i]) != true) {
                return true;
            }
        }
        return false;
    }
}
