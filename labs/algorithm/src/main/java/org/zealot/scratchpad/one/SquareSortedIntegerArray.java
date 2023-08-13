package org.zealot.scratchpad.one;

import java.util.*;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = CRAWL | HIGH | EXCELLENT | EXCELLENT | REVISIT
 *****************************************************************************************************/
public class SquareSortedIntegerArray {
    public static int[] makeSquares(int[] num) {
        // The philosophy is that end spectrum will have the highest square value. So, we have to move pointers
        // accordingly instead of looking only at one end.
        int fillingPos = 0;
        int[] squares = new int[num.length];

        // Take care of single element array input
        if (num.length == 1) {
            squares[0] = num[0] * num[0];
            return squares;
        }

        // Zero is party spoliler, latch it
        int inflexionPoint = -1;
        for(int k = 1; k < num.length; k++) {
            if ((num[k-1] < 0) && (num[k] >= 0)) {
                inflexionPoint = k;
                break;
            }
        }

        if (inflexionPoint == -1) {
            if (num[0] < num[num.length - 1])  {
                // Incrementing number only, might include negatives
                if (num[num.length - 1] < 0) {
                    fillSquareUnidirection(num, num.length - 1, squares, 0, false);
                } else {
                    fillSquareUnidirection(num, 0, squares, 0, true);
                }
            } else {
                fillSquareUnidirection(num, num.length-1, squares, 0, false);
            }
            return squares;
        }

        // So far, we have taken care of unidirection arrays including negatives. It's time
        // to consider the array which flips the sign (from negative to positive). So, we have
        // inflexion point.
        int i = inflexionPoint;
        int j = inflexionPoint + 1;
        // Fill till we can fill in both sides, do not be too greedy
        while ((i >= 0) && (j < num.length)) {
            // Compare both sides using absolute value
            if (Math.abs(num[i]) <= Math.abs(num[j])) {
                squares[fillingPos++] = num[i] * num[i];
                i--;
            } else {
                squares[fillingPos++] = num[j] * num[j];
                j++;
            }
        }

        // There may be some portions which might not have been considered as we reached
        // one of the end. Let us deal with them.
        if (i < 0) {
            // We can not move further, whatever is left is in right side of inflexion point
            fillSquareUnidirection(num, j, squares, fillingPos, true);
        } else if (j == num.length) {
            // We reached right side of inflexion point. See if we can fill left side if there are any
            // to be filled.
            fillSquareUnidirection(num, i, squares, fillingPos, false);
        }

        return squares;
    }

    public static void fillSquareUnidirection(int[] nums, int start, int[] squares, int squareStart, boolean upward) {
        if (upward) {
            for(int k = start; k < nums.length; k++) {
                squares[squareStart++] = nums[k] * nums[k];
            }
        } else {
            for(int k = start; k >= 0; k--) {
                squares[squareStart++] = nums[k] * nums[k];
            }
        }
    }

    public static int[] makeSquaresMergeList(int[] num) {
        int fillingPos = 0;
        int[] squares = new int[num.length];
        if (num.length == 1) {
            squares[0] = num[0] * num[0];
            return squares;
        }

        int inflexionPoint = -1;
        for(int k = 1; k < num.length; k++) {
            if ((num[k-1] < 0) && (num[k] >= 0)) {
                inflexionPoint = k;
                break;
            }
        }

        if (inflexionPoint == -1) {
            // Unidirectional array, all negatives will lead to deecending array (caution)
            if (num[num.length - 1] < 0) {
                for(int k = num.length - 1; k >= 0; k--) {
                    squares[fillingPos++] = num[k] * num[k];
                }
                return squares;
            } else {
                for(int k = 0; k < num.length; k++) {
                    squares[fillingPos++] = num[k] * num[k];
                }
                return squares;
            }
        }

        // Let us prepare two list: left side and right side
        // Left list
        int[] leftListSquare = new int[inflexionPoint];
        for(int i = 0; i < leftListSquare.length; i++) {
            leftListSquare[i] = num[inflexionPoint - i - 1] * num[inflexionPoint - i - 1];
        }
        // Right list
        int[] rightListSquare = new int[num.length - inflexionPoint];
        for(int i = 0; i < rightListSquare.length; i++) {
            rightListSquare[i] = num[inflexionPoint + i] * num[inflexionPoint + i];
        }

        // Merge two sorted array
        int i = 0, j = 0;
        while((i < leftListSquare.length) && (j < rightListSquare.length)){
            if (leftListSquare[i] <= rightListSquare[j]) {
                squares[fillingPos++] = leftListSquare[i];
                i++;
            } else {
                squares[fillingPos++] = rightListSquare[j];
                j++;
            }
        }
        if (i < leftListSquare.length) {
            for(int k = i; k < leftListSquare.length; k++) {
                squares[fillingPos++] = leftListSquare[k];
            }
        }
        if (j < rightListSquare.length) {
            for(int k = j; k < rightListSquare.length; k++) {
                squares[fillingPos++] = rightListSquare[k];
            }
        }
        return squares;
    }
}
