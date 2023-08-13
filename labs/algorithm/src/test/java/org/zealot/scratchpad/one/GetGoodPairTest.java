package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GetGoodPairTest {
    @Test
    void find() {
        GetGoodPair gp = new GetGoodPair();
        int[] nums1 = new int[]{1,2,3,1,1,3};
        System.out.println(String.format("Good pair analysis for = %s, count=[%d]", Arrays.toString(nums1), gp.find(nums1)));
        nums1 = new int[]{1,1,1,1};
        System.out.println(String.format("Good pair analysis for = %s, count=[%d]", Arrays.toString(nums1), gp.find(nums1)));
        nums1 = new int[]{1,2,3};
        System.out.println(String.format("Good pair analysis for = %s, count=[%d]", Arrays.toString(nums1), gp.find(nums1)));
    }
}
