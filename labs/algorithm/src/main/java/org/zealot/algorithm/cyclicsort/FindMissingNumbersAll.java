package org.zealot.algorithm.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingNumbersAll {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i =0 ;
        while(i < nums.length){
            if ((i+1) != nums[i]){
                // Hmm, mis-aligned!
                // Time to swap to its correct position
                int j = nums[i]-1;
                if (nums[j] == nums[i]) {
                    // found duplicate, no point in swapping
                    i++;
                } else {
                    // swap it
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            } else {
                // numbers are at its correct place
                i++;
            }
        }

        for(int k=0; k<nums.length; k++) {
            if ((k+1) != nums[k]) {
                missingNumbers.add(k+1);
            }
        }
        return missingNumbers;
    }
}
