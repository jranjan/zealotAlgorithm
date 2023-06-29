package org.zealot.algorithm.twopointers;

public class RemoveDuplicates {
    public static int solution(int[] arr) {
        int prev = 0, curr = 1;
        int count = 1;
        while(curr<arr.length) {
            if (arr[prev] != arr[curr]){
                if ((curr - prev) > 1){
                    arr[prev+1] = arr[curr];
                }
                prev = curr;
                curr = curr + 1;
                count++;
            } else {
                curr = curr + 1;
            }
        }
        
        return count;
    }
}
