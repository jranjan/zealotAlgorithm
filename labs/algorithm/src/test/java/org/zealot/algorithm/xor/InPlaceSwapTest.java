package org.zealot.algorithm.xor;

import org.junit.jupiter.api.Test;
import xor.InPlaceSwap;

import java.util.Arrays;

public class InPlaceSwapTest {
    @Test
    void swap(){
        int[] num = new int[]{20, 30};
        System.out.println("Before swap:" + Arrays.toString(num));
        InPlaceSwap.swap(num);
        System.out.println("After swap:" + Arrays.toString(num));;
    }
}
