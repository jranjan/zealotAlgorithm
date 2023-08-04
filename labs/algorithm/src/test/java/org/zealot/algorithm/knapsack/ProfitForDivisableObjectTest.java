package org.zealot.algorithm.knapsack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProfitForDivisableObjectTest {
    @Test
    void getMaxProfit() {
        int[] profit1 = new int[]{4, 5, 1, 7, 9};
        int[] weight1 = new int[]{2, 20, 12, 4, 3};
        int capacity11 = 22;
        System.out.println("--------------------- solveKnapsack --------------------------");
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity11 + " Maximum profit: " +
                ProfitForDivisableObject.solveKnapsack(profit1, weight1, capacity11));
        int capacity12 = 1;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity12 + " Maximum profit: " +
                ProfitForDivisableObject.solveKnapsack(profit1, weight1, capacity12));
        int capacity13 = 101;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity13 + " Maximum profit: " +
                ProfitForDivisableObject.solveKnapsack(profit1, weight1, capacity13));


        int[] profit2 = new int[]{1,6,10,16};
        int[] weight2 = new int[]{1,2,3,5};
        int capacity2 = 7;
        System.out.println("Profit: " + Arrays.toString(profit2) + " :: " + "Weight: " + Arrays.toString(weight2) +
                " Capacity: " + capacity2 + " Maximum profit: " +
                ProfitForDivisableObject.solveKnapsack(profit2, weight2, capacity2));
    }
}
