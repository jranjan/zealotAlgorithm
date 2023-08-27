package org.zealot.algorithm.pattern.cyclicsort;

public class FindDuplicateNumber {
    public static int findNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if ((i+1) != nums[i]){
                // time to swap if we can. Note that it contains duplicate
                int j = nums[i] - 1;
                if (nums[i] == nums[j]) {
                    // How come we have two numbers at the same place? It means that this is duplicate.
                    return nums[i];
                } else {
                    // swap and move on
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    public static int findNumberUsingLoopDetection(int[] arr) {
        // Overall I understand but not sure code though.
        // 1. Find the cycle
        // 2. Find the cycle length (it's ok)
        // 3. Find the start of the cycle, note that cycle can have non-duplicates as well
        // Mostly, it sounds non-intuitive without pointer
        int slow = 0, fast = 0;
        // Its cryptic
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // find cycle length
        int current = arr[slow];
        int cycleLength = 0;
        do {
            current = arr[current];
            cycleLength++;
        } while (current != arr[slow]);

        return findStart(arr, cycleLength);
    }

    private static int findStart(int[] arr, int cycleLength) {
        int pointer1 = arr[0], pointer2 = arr[0];
        // move pointer2 ahead 'cycleLength' steps
        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }
}
