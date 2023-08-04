package org.zealot.algorithm.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfitforSolidObject {
    public static int solveKnapsackBruteForce(int[] profits, int[] weights, int capacity) {
        int maxSolution = (int) Math.pow(2, weights.length);


        int maxProfitPosition = -1;
        int maxProfit = 0;
        for(int i = 0; i < maxSolution; i++) {
            int[] choices = new int[weights.length];

            int bitPos = choices.length - 1;
            int val = i;
            while(val > 0) {
                choices[bitPos--] = val % 2;
                val = val / 2;
            }

            // compute cost
            int currProfit = 0, currentCapacity = 0;
            for(int k = 0; k < choices.length; k++) {
                if (choices[k] == 1) {
                    currProfit = currProfit + profits[k];
                    currentCapacity = currentCapacity + weights[k];
                }
            }

            if ((currentCapacity <= capacity) && (currProfit > maxProfit)) {
                maxProfit = currProfit;
                maxProfitPosition = i;
            }
        }

        int[] selection = new int[weights.length];
        for(int p =0; p < selection.length; p++) selection[p] = 0;
        if (maxProfitPosition != -1) {
            int bitPos = selection.length - 1;
            int val = maxProfitPosition;
            while(val > 0) {
                selection[bitPos--] = val % 2;
                val = val / 2;
            }
        }

        System.out.println(Arrays.toString(selection));
        return maxProfit;
    }

    // It is called top-down approach for dynamic programming. Here, we go and take a big number to break
    // into smaller parts. As we do break, we hit base condition i.e. leaves of DFS and start rolling up.
    // During rolling up, we try to use previous computation instead of being aggressive to compute again
    // so that we avoid CPU cycle. But it comes with a cost as we do memorise the previous computation
    // We need to be prepared to store as many possible.
    //
    // Again, it's used for optimisation problem
    // Again, it's dynamic programming
    // Again, it's leveraging memorisation technique.
    // Again, it's complexity is lesser than O(2^n) as we do not compute every node
    public static int solveKnapsackDynamicProgrammingMemorisation(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return solveKnapsackProgrammingMemorisationHelper(dp, profits, weights, capacity, 0);
    }

    public static int solveKnapsackProgrammingMemorisationHelper(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if ((capacity <= 0) || (currentIndex >= profits.length))
            return 0;

        if(dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];

        int currProfit1 = 0;
        if (weights[currentIndex] <= capacity) {
            // we can add to the bucket
            currProfit1 = profits[currentIndex] + solveKnapsackBruteForceRecursionHelper(profits,
                    weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        int profit2 = solveKnapsackBruteForceRecursionHelper(profits, weights, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(currProfit1, profit2);
        return dp[currentIndex][capacity];
    }

    public static int solveKnapsackBruteForceRecursion(int[] profits, int[] weights, int capacity) {
        return solveKnapsackBruteForceRecursionHelper(profits, weights, capacity, 0);
    }

    public static int solveKnapsackBruteForceRecursionHelper(int[] profits, int[] weights, int capacity, int currentIndex) {
        if ((capacity <= 0) || (currentIndex >= profits.length))
            return 0;

        int currProfit1 = 0;
        if (weights[currentIndex] <= capacity) {
            // we can add to the bucket
            currProfit1 = profits[currentIndex] + solveKnapsackBruteForceRecursionHelper(profits,
                    weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        int profit2 = solveKnapsackBruteForceRecursionHelper(profits, weights, capacity, currentIndex + 1);
        return Math.max(currProfit1, profit2);
    }

    // It is called bottom-up approach for dynamic programming
    //
    // Store the profit of items for capacity starting from 0..capacity. Let us assume that you have
    // got a flexible bag which can expand up to capacity. Need to do so as we leverage earlier
    // computation (stored in table) but of lower capacity. We use that to compute best combination
    // for maximum profit.
    //
    // Again, it's dynamic programming
    // Again, its bottom, up as we tend to compute smaller element first
    // Again, it's an optimisation problem but different from backtrack which falls in greedy algorithm catagepru
    // Again, it relies on storing previous computation but in tabular method
    public static int solveKnapsackDynamicProgrammingTabularisation(int[] profits, int[] weights, int capacity) {
        if ((profits.length < 0) || (capacity <= 0) || (weights.length != profits.length)) {
            return  0;
        }

        // dp[i][c] will represent the maximum knapsack profit for capacity
        // ‘c’ calculated from the first ‘i’ items.
        int[][] dp = new int[profits.length][capacity + 1];

        // Let us populate first row to see what best we can get the profit if we have only one weight
        for(int j = 0; j < capacity + 1; j++) {
            if (weights[0] <= j) {
                dp[0][j] = profits[0];
            }
        }

        // Now we will start filling all the maze i.e. all [i,j] position but row by row
        for(int row = 1; row < profits.length; row++){
            for(int currCapacity = 1; currCapacity < capacity + 1; currCapacity++) {
                // Get the profit which does not add new item. Exclude the item
                int prevProfit = dp[row-1][currCapacity];
                // include the item, if it is not more than the capacity
                // (currCapacity - weights[row]) >= 0 tells me that we have enough capacity to absorb new load if
                // we exclude one of the weight from left side columns. In other words, we do find the cost
                // which we calculated for available capacity represented by (c - weight[row])
                // So, new profit will be profit of including current object added by the capacity we replaced in
                // the above row.
                int newProfit = ((currCapacity - weights[row]) >= 0) ? (profits[row] + dp[row-1][currCapacity-weights[row]]) : 0;

                // we will pick maximum of old and new profit
                dp[row][currCapacity] = Math.max(prevProfit, newProfit);
            }
        }

        System.out.println("Selection: " + getSelectedElements(dp, weights, profits, capacity));
        return dp[profits.length-1][capacity];
    }

    public static List<Integer> getSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
        List<Integer> selection = new ArrayList<>();
        int totalProfit = dp[weights.length-1][capacity];
        for(int i=weights.length-1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]) {
                // if we are hear than we selected the item. So, add it!
                // Or else, skip! Next iteration will add the original one who contributed to profit
                selection.add(weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }
        if (totalProfit != 0) {
            // we choose the first item also
            selection.add(weights[0]);
        }
        return selection;
    }

    public static int solveKnapsackDynamicProgrammingReducedTabularisation(int[] profits, int[] weights, int capacity) {
        if ((profits.length < 0) || (capacity <= 0) || (weights.length != profits.length)) {
            return  0;
        }

        int[][] dp = new int[2][capacity + 1];

        // Let us populate first row to see what best we can get the profit if we have only one weight
        for(int c = 0; c< capacity + 1; c++) {
            if (weights[0] <= c) {
                dp[0][c] = dp[1][c] = profits[0];
            }
        }

        // Now we will start filling all the maze i.e. all [i,j] position but row by row
        for(int row = 1; row < profits.length; row++){
            for(int c = 1; c < capacity + 1; c++) {
                int prevProfit = dp[(row-1)%2][c];
                int newProfit = ((c - weights[row]) >= 0) ? (profits[row] + dp[(row-1)%2][c-weights[row]]) : 0;
                dp[row%2][c] = Math.max(prevProfit, newProfit);
            }
        }

        return dp[(profits.length-1)%2][capacity];
    }

}
