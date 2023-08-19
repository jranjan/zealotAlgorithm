package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.SquareSortedIntegerArray;

import java.util.Arrays;


public class SquareSortedIntegerArrayTest {

    @Test
    void verify(){
        System.out.println("****** test count = 1");
        int[] nums = new int[]{25};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{-3, -2, -1};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{1, 2, 3, 9};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{1, 1, 1, 1};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{-2, -1, 0, 3, 9};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{-2, -1, 0, 2, 3};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{-3, -1, 0, 1, 2};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
        nums = new int[]{-4, -2, 0, 2, 4};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquares(nums))));
    }

    @Test
    void verifyUsingMerge(){
        System.out.println("****** test count = 2");
        int[] nums = new int[]{25};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{-3, -2, -1};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{1, 2, 3, 9};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{1, 1, 1, 1};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{-2, -1, 0, 3, 9};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{-2, -1, 0, 2, 3};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{-3, -1, 0, 1, 2};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
        nums = new int[]{-4, -2, 0, 2, 4};
        System.out.println(String.format("Numbers=%s, Sorted numbers=%s", Arrays.toString(nums),
                Arrays.toString(SquareSortedIntegerArray.makeSquaresMergeList(nums))));
    }
}
