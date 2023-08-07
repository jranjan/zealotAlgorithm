package org.zealot.algorithm.twopointers;
import java.lang.Math;
import java.util.Arrays;

public class SquareSortedArray {

    public static int[] makeSquaresCrud(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = Math.abs(arr[i]);
            }
        }

        Arrays.sort(arr);

        int[] sqrarr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            sqrarr[i] = arr[i] * arr[i];
        }

        return sqrarr;
    }

    public static int[] makeSquares(int[] arr) {
        if (arr.length == 1) {
            return new int[]{arr[0]*arr[0]};
        }

        int marker = -1;
        for(int i=0; i<arr.length; i++){
            if (arr[i] >= 0) {
                marker = i;
                break;
            }
        }

        int[] sqrarr = new int[arr.length];
        int p=marker, n=marker-1;
        for(int i=0; i<arr.length; i++){
            if (marker == 0) {
                // all positives
                sqrarr[i] = arr[i] * arr[i];
            } else if (marker == -1) {
                // all negatives
                sqrarr[i] = arr[arr.length-i-1] * arr[arr.length-i-1];
            } else {
                if (arr[p] <= Math.abs(arr[n])) {
                    sqrarr[i] = arr[p] * arr[p];
                    p++;
                    if (p >= arr.length) {
                        marker = -1;
                    }
                } else {
                    sqrarr[i] = arr[n] * arr[n];
                    n--;
                    if (n<0) {
                        marker = 0;
                    }
                }
            }
        }

        return sqrarr;
    }
    public static int[] makeSquaresSimplified(int[] arr) {
        int sp=0, ep=arr.length-1;
        int[] sqrarr = new int[arr.length];
        int i=arr.length-1;
        while(sp <= ep){
            int ls = arr[sp] * arr[sp];
            int rs = arr[ep] * arr[ep];
            if (ls > rs){
                sqrarr[i--] = ls;
                sp++;
            } else {
                sqrarr[i--] = rs;
                ep--;
            }
        }

        return sqrarr;
    }
}
