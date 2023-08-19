package org.zealot.algorithm.pattern.xor;

public class TwoSingleNumber {
    public static int[] single(int[] nums){
        int x1 = nums[0];
        for(int i=1; i<nums.length; i++){
            x1 = x1 ^ nums[i];
        }

        int rightmostSetBit = 1;
        while ((rightmostSetBit & x1) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        int num1 = 0, num2 = 0;
        // Divided the array into two groups: one rightmostSetBit set to 1 else others set to 0.
        // After that try to find the missing number from one set.
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }
}
