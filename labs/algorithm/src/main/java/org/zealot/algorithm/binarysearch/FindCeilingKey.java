package org.zealot.algorithm.binarysearch;

public class FindCeilingKey {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start = 0, end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                // got the ceiling, easy if it is equal
                // ask is for smallest in the array but greater than or equal to key
                // hit the bulls eye
                return mid;
            } else {
                if ((end - start) <= 1) {
                    // Ideally number is in-between these two or does not exist
                    if (key < arr[start]) {
                        return start;
                    } else {
                        if (key < arr[end]) {
                            return end;
                        }
                    }
                }
            }

            if (arr[mid] > key) {
                // time to go to left side
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int searchCeilingOfANumberCleanerWay(int[] arr, int key) {
        if (key > arr[arr.length-1]) return  -1;

        int start = 0, end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                // got the ceiling, easy if it is equal
                // ask is for smallest in the array but greater than or equal to key
                // hit the bulls eye
                return mid;
            }

            if (arr[mid] > key) {
                // time to go to left side
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
