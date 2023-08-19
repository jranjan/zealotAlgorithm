package org.zealot.algorithm.pattern.twopointers;

public class RemoveSpecificKey {
    public static int solution(int[] arr, int key) {
        int count = 0;
        int prev = -1, curr = 0;
        while(curr < arr.length){
            if (arr[curr] != key){
                if (prev == -1){
                    prev = curr;
                } else {
                    prev = curr;
                    arr[prev] = arr[curr];
                }
                count++;
            }

            curr++;
        }

        return count;
    }
}
