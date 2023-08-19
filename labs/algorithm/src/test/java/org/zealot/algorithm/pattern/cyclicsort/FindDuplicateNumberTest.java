package org.zealot.algorithm.pattern.cyclicsort;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.cyclicsort.FindDuplicateNumber;

import java.util.Arrays;

public class FindDuplicateNumberTest {
    @Test
    void findMissingNumbers(){
        int[] nums1 = new int[]{1, 4, 4, 3, 2};
        System.out.println(Arrays.toString(nums1) + ":"+ FindDuplicateNumber.findNumber(nums1));
        int[] nums2 = new int[]{2, 1, 3, 3, 5, 4};
        System.out.println(Arrays.toString(nums2) + ":"+ FindDuplicateNumber.findNumber(nums2));
        int[] nums3 = new int[]{2, 4, 1, 4, 4};
        System.out.println(Arrays.toString(nums3) + ":"+ FindDuplicateNumber.findNumber(nums3));
    }

    @Test
    void findMissingNumbersUsingLinkedList(){
        int[] nums1 = new int[]{1, 4, 4, 3, 2};
        System.out.println(Arrays.toString(nums1) + ":"+ FindDuplicateNumber.findNumberUsingLoopDetection(nums1));
        int[] nums2 = new int[]{2, 1, 3, 3, 5, 4};
        System.out.println(Arrays.toString(nums2) + ":"+ FindDuplicateNumber.findNumberUsingLoopDetection(nums2));
        int[] nums3 = new int[]{2, 4, 1, 4, 4};
        System.out.println(Arrays.toString(nums3) + ":"+ FindDuplicateNumber.findNumberUsingLoopDetection(nums3));
    }
}
