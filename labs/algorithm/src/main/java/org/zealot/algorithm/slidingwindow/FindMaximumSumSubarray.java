package org.zealot.algorithm.slidingwindow;

public class FindMaximumSumSubarray {
    public static int findMaximum(int K, int[] arr) {
        boolean bFound = false;
        int windowMaximum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= K-1) {
                // Time to compare with maximum sum
                if (bFound) {
                    windowMaximum = Math.max(windowMaximum, windowSum);
                } else {
                    windowMaximum = windowSum;
                    bFound = true;
                }
                // Remove the impact of first element of sliding window
                windowSum -= arr[windowStart++];
            }
        }
        return  windowMaximum;
    }
}
