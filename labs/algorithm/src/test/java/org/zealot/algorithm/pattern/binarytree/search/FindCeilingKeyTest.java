package org.zealot.algorithm.pattern.binarytree.search;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.binarytree.search.FindCeilingKey;

import java.util.Arrays;

public class FindCeilingKeyTest {
    @Test
    void findCeiling(){
        int[] num1 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num1) + ":" + FindCeilingKey.searchCeilingOfANumber(num1, 6));
        int[] num2 = new int[]{1, 3, 8, 10, 15};
        System.out.println(Arrays.toString(num2) + ":" + FindCeilingKey.searchCeilingOfANumber(num2, 12));
        int[] num3 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num3) + ":" + FindCeilingKey.searchCeilingOfANumber(num3, 17));
        int[] num4 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num4) + ":" + FindCeilingKey.searchCeilingOfANumber(num4, -1));
        int[] num5 = new int[]{10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(num5) + ":" + FindCeilingKey.searchCeilingOfANumber(num5, 35));
        int[] num6 = new int[]{10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(num6) + ":" + FindCeilingKey.searchCeilingOfANumber(num6, -1));
    }

    @Test
    void findCeilingCleanerWay(){
        int[] num1 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num1) + ":" + FindCeilingKey.searchCeilingOfANumberCleanerWay(num1, 6));
        int[] num2 = new int[]{1, 3, 8, 10, 15};
        System.out.println(Arrays.toString(num2) + ":" + FindCeilingKey.searchCeilingOfANumberCleanerWay(num2, 12));
        int[] num3 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num3) + ":" + FindCeilingKey.searchCeilingOfANumberCleanerWay(num3, 17));
        int[] num4 = new int[]{4, 6, 10};
        System.out.println(Arrays.toString(num4) + ":" + FindCeilingKey.searchCeilingOfANumberCleanerWay(num4, -1));
        int[] num5 = new int[]{10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(num5) + ":" + FindCeilingKey.searchCeilingOfANumberCleanerWay(num5, 35));
        int[] num6 = new int[]{10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(num6) + ":" + FindCeilingKey.searchCeilingOfANumberCleanerWay(num6, -1));
    }
}
