package org.zealot.algorithm.cyclicsort;

public class FindMissingNumber {
    public static int findMissingNumber(int[] nums) {
        int X1 = 0;
        for(int i=1; i<nums.length+1; i++){
            X1 = X1 ^ i;
        }

        for(int j=0; j<nums.length; j++) {
            X1 = X1 ^ nums[j];
        }

        return X1;
    }

    public static int findMissingNumberCyclicWay(int[] nums) {
        int i=0;
        while(i<nums.length){
            if ((i != nums[i]) && (nums[i] < nums.length)) {
                // swap the number
                int j = nums[i];
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            } else {
                i++;
            }
        }

        for(int j=0; j<nums.length; j++) {
            if (j != nums[j]) {
                return j;
            }
        }

        return nums.length;
    }
}
