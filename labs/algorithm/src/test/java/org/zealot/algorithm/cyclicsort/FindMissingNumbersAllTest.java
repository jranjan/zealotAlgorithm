package org.zealot.algorithm.cyclicsort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingNumbersAllTest {
    @Test
    void findMissingNumbers(){
        int[] nums1 = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println(Arrays.toString(nums1) + ":"+ FindMissingNumbersAll.findNumbers(nums1));
        int[] nums2 = new int[]{2, 4, 1, 2};
        System.out.println(Arrays.toString(nums1) + ":"+ FindMissingNumbersAll.findNumbers(nums2));
        int[] nums3 = new int[]{2, 3, 2, 1};
        System.out.println(Arrays.toString(nums1) + ":"+ FindMissingNumbersAll.findNumbers(nums3));
    }
}
