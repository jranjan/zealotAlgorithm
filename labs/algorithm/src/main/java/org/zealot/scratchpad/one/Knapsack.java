package org.zealot.scratchpad.one;

public class Knapsack {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return findOptimalRecursive(profits, weights, capacity, 0);
    }

    public static int findOptimalRecursive(int[] profits, int[] weights, int capacity, int pos) {
        if ((capacity <= 0) || (pos >= profits.length)) {
            return 0;
        }

        int profit1 = 0;
        if( weights[pos] <= capacity ) {
            profit1 = profits[pos] + findOptimalRecursive(profits, weights,
                    capacity - weights[pos], pos + 1);
        }

        int profit2 = findOptimalRecursive(profits, weights, capacity, pos + 1);


        return Math.max(profit1, profit2);
    }
}
