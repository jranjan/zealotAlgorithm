package org.zealot.algorithm.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IslandCountTest {
    @Test
    void countIslands() {
        System.out.println(" ------------- countIslandsBruteForce  ------------- ");
        int[][] islandMap1 = new int[][]{
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        IslandCount.printMatrix(islandMap1);
        System.out.println("Map count = " + IslandCount.countIslandsBruteForce(islandMap1));

        int[][] islandMap2 = new int[][]{
                {1, 0, 1, 1, 1},
        };
        IslandCount.printMatrix(islandMap2);
        System.out.println("Map count = " + IslandCount.countIslandsBruteForce(islandMap2));
    }
}
