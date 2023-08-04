package org.zealot.algorithm.cyclicsort;

import java.util.Arrays;

public class Sort {
    public static int[] sort(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if ((i+1) != nums[i]) {
                // swap this to place where it belongs
                int j = nums[i]-1;
                nums[j] = nums[j] ^ nums[i];
                nums[i] = nums[j] ^ nums[i];;
                nums[j] = nums[j] ^ nums[i];
            }

            // So, we put ith position at right place but we might have disturbed another one
            // So, we will move further only if the the current position is all set.
            if ((i+1) == nums[i]) {
                i++;
            }
        }
        return nums;
    }
}
