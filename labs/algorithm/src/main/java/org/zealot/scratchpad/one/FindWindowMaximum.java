package org.zealot.scratchpad.one;

public class FindWindowMaximum {
    public static int maximum(int[] num, int k) {
        if ((k < 0) || (k > num.length)) return  -1;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += num[i];
        }

        int maximumWindowSum = windowSum;
        for (int j = k; j < num.length; j++) {
            windowSum = windowSum - num[j - k] + num[j];
            if (windowSum > maximumWindowSum) {
                maximumWindowSum = windowSum;
            }
        }

        return maximumWindowSum;
    }
}
