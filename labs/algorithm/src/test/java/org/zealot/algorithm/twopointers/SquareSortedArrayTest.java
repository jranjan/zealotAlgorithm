package org.zealot.algorithm.twopointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquareSortedArrayTest {
    @Test
    void element(){
        int[] nums = new int[]{25};
        int[] sqrnums = SquareSortedArray.makeSquares(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{-3, -2, -1};
        sqrnums = SquareSortedArray.makeSquares(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{1, 2, 3, 9};
        sqrnums = SquareSortedArray.makeSquares(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{-2, -1, 0, 3, 9};
        sqrnums = SquareSortedArray.makeSquares(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));
    }
    @Test
    void elementCrude(){
        int[] nums = new int[]{25};
        int[] sqrnums = SquareSortedArray.makeSquaresCrud(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{-3, -2, -1};
        sqrnums = SquareSortedArray.makeSquaresCrud(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{1, 2, 3, 9};
        sqrnums = SquareSortedArray.makeSquaresCrud(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{-2, -1, 0, 3, 9};
        sqrnums = SquareSortedArray.makeSquaresCrud(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));
    }

    @Test
    void elementSimplified(){
        int[] nums = new int[]{25};
        int[] sqrnums = SquareSortedArray.makeSquaresSimplified(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{-3, -2, -1};
        sqrnums = SquareSortedArray.makeSquaresSimplified(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{1, 2, 3, 9};
        sqrnums = SquareSortedArray.makeSquaresSimplified(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));

        nums = new int[]{-2, -1, 0, 3, 9};
        sqrnums = SquareSortedArray.makeSquaresSimplified(nums);
        assertTrue(nums.length == sqrnums.length);
        System.out.println(Arrays.toString(sqrnums));
    }
}
