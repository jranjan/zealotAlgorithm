package org.zealot.algorithm.pattern.cyclicsort;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.cyclicsort.FindMissingNumber;

import java.util.Arrays;

public class FindMissingNumberTest {
    @Test
    void findMissingNumber(){
        int[] nums1 = new int[]{4, 0, 3, 1};
        System.out.println(Arrays.toString(nums1) + ":"+ FindMissingNumber.findMissingNumber(nums1));
    }

    @Test
    void findMissingNumberCyclicWay(){
        int[] nums1 = new int[]{4, 0, 3, 1};
        System.out.println(Arrays.toString(nums1) + ":"+ FindMissingNumber.findMissingNumberCyclicWay(nums1));
    }
}
