package org.zealot.algorithm.pattern.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean solution(int[] numbers) {
        for(int i=0; i< numbers.length; i++)
            for(int j=i+1; j<numbers.length; j++) {
                if (numbers[i] == numbers[j])
                    return true;
            }
        return false;
    }

    public static boolean solutionUsingSet(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int n : numbers) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static boolean solutionSortArray(int[] numbers) {
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length-1; i++) {
            if (numbers[i] == numbers[i+1]) {
                    return true;
            }
        }

        return false;
    }
}
