package org.zealot.algorithm.pattern.knapsack;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.knapsack.ProfitforSolidObject;

import java.util.Arrays;

public class ProfitForSolidObjectTest {
    @Test
    void getMaxProfitBruteForce() {
        int[] profit1 = new int[]{4, 5, 1, 7, 9};
        int[] weight1 = new int[]{2, 20, 12, 4, 3};
        int capacity11 = 22;
        System.out.println("--------------------- solveKnapsackBruteForce --------------------------");
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity11 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForce(profit1, weight1, capacity11));
        int capacity12 = 1;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity12 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForce(profit1, weight1, capacity12));
        int capacity13 = 101;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity13 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForce(profit1, weight1, capacity13));


        int[] profit2 = new int[]{1,6,10,16};
        int[] weight2 = new int[]{1,2,3,5};
        int capacity2 = 7;
        System.out.println("Profit: " + Arrays.toString(profit2) + " :: " + "Weight: " + Arrays.toString(weight2) +
                " Capacity: " + capacity2 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForce(profit2, weight2, capacity2));
    }

    @Test
    void getMaxProfitBruteForceRecursion() {
        int[] profit1 = new int[]{4, 5, 1, 7, 9};
        int[] weight1 = new int[]{2, 20, 12, 4, 3};
        int capacity11 = 22;
        System.out.println("--------------------- solveKnapsackBruteForceRecursion --------------------------");
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity11 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForceRecursion(profit1, weight1, capacity11));
        int capacity12 = 1;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity12 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForceRecursion(profit1, weight1, capacity12));
        int capacity13 = 101;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity13 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForceRecursion(profit1, weight1, capacity13));


        int[] profit2 = new int[]{1,6,10,16};
        int[] weight2 = new int[]{1,2,3,5};
        int capacity2 = 7;
        System.out.println("Profit: " + Arrays.toString(profit2) + " :: " + "Weight: " + Arrays.toString(weight2) +
                " Capacity: " + capacity2 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackBruteForceRecursion(profit2, weight2, capacity2));
    }

    @Test
    void getMaxProfitDynamicProgrammingMemorisation() {
        int[] profit1 = new int[]{4, 5, 1, 7, 9};
        int[] weight1 = new int[]{2, 20, 12, 4, 3};
        int capacity11 = 22;
        System.out.println("--------------------- solveKnapsackDynamicProgrammingMemorisation --------------------------");
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity11 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingMemorisation(profit1, weight1, capacity11));
        int capacity12 = 1;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity12 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingMemorisation(profit1, weight1, capacity12));
        int capacity13 = 101;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity13 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingMemorisation(profit1, weight1, capacity13));


        int[] profit2 = new int[]{1,6,10,16};
        int[] weight2 = new int[]{1,2,3,5};
        int capacity2 = 7;
        System.out.println("Profit: " + Arrays.toString(profit2) + " :: " + "Weight: " + Arrays.toString(weight2) +
                " Capacity: " + capacity2 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingMemorisation(profit2, weight2, capacity2));
    }

    @Test
    void getMaxProfitDynamicProgrammingTabularisation() {
        int[] profit1 = new int[]{4, 5, 1, 7, 9};
        int[] weight1 = new int[]{2, 20, 12, 4, 3};
        int capacity11 = 22;
        System.out.println("--------------------- solveKnapsackDynamicProgrammingTabularisation --------------------------");
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity11 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingTabularisation(profit1, weight1, capacity11));
        int capacity12 = 1;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity12 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingTabularisation(profit1, weight1, capacity12));
        int capacity13 = 101;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity13 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingTabularisation(profit1, weight1, capacity13));


        int[] profit2 = new int[]{1,6,10,16};
        int[] weight2 = new int[]{1,2,3,5};
        int capacity2 = 7;
        System.out.println("Profit: " + Arrays.toString(profit2) + " :: " + "Weight: " + Arrays.toString(weight2) +
                " Capacity: " + capacity2 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingTabularisation(profit2, weight2, capacity2));
    }

    @Test
    void getMaxProfitDynamicProgrammingTabularisationTwoRow() {
        int[] profit1 = new int[]{4, 5, 1, 7, 9};
        int[] weight1 = new int[]{2, 20, 12, 4, 3};
        int capacity11 = 22;
        System.out.println("--------------------- solveKnapsackDynamicProgrammingTabularisationTwoRow --------------------------");
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity11 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingReducedTabularisation(profit1, weight1, capacity11));
        int capacity12 = 1;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity12 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingReducedTabularisation(profit1, weight1, capacity12));
        int capacity13 = 101;
        System.out.println("Profit: " + Arrays.toString(profit1) + " :: " + "Weight: " + Arrays.toString(weight1) +
                " Capacity: " + capacity13 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingReducedTabularisation(profit1, weight1, capacity13));


        int[] profit2 = new int[]{1,6,10,16};
        int[] weight2 = new int[]{1,2,3,5};
        int capacity2 = 7;
        System.out.println("Profit: " + Arrays.toString(profit2) + " :: " + "Weight: " + Arrays.toString(weight2) +
                " Capacity: " + capacity2 + " Maximum profit: " +
                ProfitforSolidObject.solveKnapsackDynamicProgrammingReducedTabularisation(profit2, weight2, capacity2));
    }
}
