package org.zealot.algorithm.pattern.backtracking;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.backtracking.CombinationSum;

import java.util.Arrays;
import java.util.List;

public class CombinationSumTest {
    @Test
    void findAll(){
        int[] nums1 = new int[]{2, 3, 6, 7};
        System.out.println("Input="+ Arrays.toString(nums1) + " Target=" + 7);
        List<List<Integer>> listOfList1 = CombinationSum.combinationSum(nums1, 7);
        System.out.println(listOfList1.toString());

        int[] nums2 = new int[]{2, 4, 6, 8};
        System.out.println("Input="+ Arrays.toString(nums2) + " Target=" + 10);
        List<List<Integer>> listOfList2 = CombinationSum.combinationSum(nums2, 10);
        System.out.println(listOfList2.toString());
    }

    @Test
    void findAllClean(){
        int[] nums1 = new int[]{2, 3, 6, 7};
        System.out.println("findAllClean Input="+ Arrays.toString(nums1) + " Target=" + 7);
        List<List<Integer>> listOfList1 = CombinationSum.combinationSumClean(nums1, 7);
        System.out.println(listOfList1.toString());

        int[] nums2 = new int[]{2, 4, 6, 8};
        System.out.println("findAllClean Input="+ Arrays.toString(nums2) + " Target=" + 10);
        List<List<Integer>> listOfList2 = CombinationSum.combinationSumClean(nums2, 10);
        System.out.println(listOfList2.toString());
    }
}
