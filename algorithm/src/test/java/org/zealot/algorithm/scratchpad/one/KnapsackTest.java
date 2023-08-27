package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.Knapsack;

import java.util.Arrays;

public class KnapsackTest {
    @Test
    void getMaxProfitBruteForce() {
        int[] profit = new int[]{4, 5, 1, 7, 9};
        int[] weight = new int[]{2, 20, 12, 4, 3};

        int capacity = 1;
        System.out.println("Profit:%s, weights=%s, capacity=%d, profit=%d".format(Arrays.toString(profit),
                Arrays.toString(weight), capacity, Knapsack.solveKnapsack(profit, weight, capacity)));

        capacity = 22;
        System.out.println(("Profit:%s, weights=%s, capacity=%d, " +
                "profit=%d").format(Arrays.toString(profit), Arrays.toString(weight),
                capacity, Knapsack.solveKnapsack(profit, weight, capacity)));

        capacity = 101;
        System.out.println(("Profit:%s, weights=%s, capacity=%d, " +
                "profit=%d").format(Arrays.toString(profit), Arrays.toString(weight),
                capacity, Knapsack.solveKnapsack(profit, weight, capacity)));

        profit = new int[]{1,6,10,16};
        weight = new int[]{1,2,3,5};
        capacity = 7;
        System.out.println(("Profit:%s, weights=%s, capacity=%d, " +
                "profit=%d").format(Arrays.toString(profit), Arrays.toString(weight),
                capacity, Knapsack.solveKnapsack(profit, weight, capacity)));
    }

}
