package org.zealot.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindElementInSortedArray {
    public static int search(int[] arr, int key) {
        //if (arr[0] == key) return 0;
        boolean bAscending = (arr[0] <= arr[arr.length-1]) ? true : false;
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            //if (arr[start] == key) return start;
            //if (arr[end] == key) return end;

            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key){
                if (bAscending) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (bAscending) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1; // element not found
    }
}
