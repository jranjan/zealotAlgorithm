package org.zealot.scratchpad.one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindZeroTripletTest {
    @Test
    void tripletExistsTargetSum() {
        System.out.println("****** test count : 1 *********");

        int[] num = new int[]{-3, 0, 1, 2, -1, 1, -2};
        System.out.println(String.format("Input = %s, triplets=%s", Arrays.toString(num),
                FindZeroTripletSum.tripletSearch(num)));

        num = new int[]{-5, 2, -1, -2, 3};
        System.out.println(String.format("Input = %s, triplets=%s", Arrays.toString(num),
                FindZeroTripletSum.tripletSearch(num)));

        num = new int[]{0, 0, 0, 0};
        System.out.println(String.format("Input = %s, triplets=%s", Arrays.toString(num),
                FindZeroTripletSum.tripletSearch(num)));
    }
}
