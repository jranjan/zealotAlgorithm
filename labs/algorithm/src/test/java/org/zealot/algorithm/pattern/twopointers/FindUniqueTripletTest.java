package org.zealot.algorithm.pattern.twopointers;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.twopointers.FindUniqueTriplet;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindUniqueTripletTest {
    @Test
    void tripletExists() {
        int[] num = new int[]{-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = FindUniqueTriplet.solution(num);
        System.out.println(result);
        assertTrue(result.size() == 4);
    }

    @Test
    void tripletExistsTargetSum() {
        int[] num = new int[]{-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = FindUniqueTriplet.solutionTargetSum(num);
        System.out.println(result);
        assertTrue(result.size() == 4);
        int[] zeros = new int[]{0, 0, 0};
        List<List<Integer>> zerosResult = FindUniqueTriplet.solutionTargetSum(zeros);
        System.out.println(zerosResult);
        assertTrue(zerosResult.size() == 1);
    }
}
