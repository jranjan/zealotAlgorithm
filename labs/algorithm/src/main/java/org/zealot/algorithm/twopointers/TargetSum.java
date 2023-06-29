package org.zealot.algorithm.twopointers;

import java.util.HashMap;

public class TargetSum {
    public static int[] solution(int[] arr, int targetSum) {
        int i = 0;
        int j = arr.length - 1;
        int[] positions = new int[]{-1, -1};
        while(i<j){
            int sum = arr[i] + arr[j];
            if (sum == targetSum) {
                positions[0]=i;
                positions[1]=j;
                return positions;
            } else {
                if (sum > targetSum) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return positions;
    }

    public static int[] solutionHashmap(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int pair = targetSum - arr[i];
            if (nums.containsKey(pair)) {
                return new int[]{nums.get(pair), i};
            } else {
                nums.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
