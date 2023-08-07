package org.zealot.scratchpad;

import java.util.HashSet;
import java.util.Set;

public class CheckArrayDuplicates {
    public boolean algorithmUsingSet(int[] numbers) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            if (s.add(numbers[i]) != true) {
                return true;
            }
        }
        return false;
    }
}
