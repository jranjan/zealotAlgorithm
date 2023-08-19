package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.MatrixCountIsland;

public class MatrixCountIslandTest {
    @Test
    void getIslandDFS() {
        System.out.println("******** test 1 ********");
        int[][] island = new int[][]{
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        MatrixCountIsland.printMatrix(island);
        System.out.println(String.format("Island count = %d", MatrixCountIsland.getIslandsDFS(island)));

        System.out.println("--------------------");
        island = new int[][]{
                {1, 0, 1, 1, 1},
        };
        MatrixCountIsland.printMatrix(island);
        System.out.println(String.format("Island count = %d", MatrixCountIsland.getIslandsDFS(island)));
    }

    @Test
    void getIslandBFS() {
        System.out.println("******** test 2 ********");
        int[][] island = new int[][]{
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        MatrixCountIsland.printMatrix(island);
        System.out.println(String.format("Island count = %d", MatrixCountIsland.getIslandsBFS(island)));

        System.out.println("--------------------");
        island = new int[][]{
                {1, 0, 1, 1, 1},
        };
        MatrixCountIsland.printMatrix(island);
        System.out.println(String.format("Island count = %d", MatrixCountIsland.getIslandsBFS(island)));
    }


    @Test
    void getIslandBFSTabulate() {
        System.out.println("******** test 3 ********");
        int[][] island = new int[][]{
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        MatrixCountIsland.printMatrix(island);
        System.out.println(String.format("Island count = %d", MatrixCountIsland.getIslandsBFSTabulate(island)));

        System.out.println("--------------------");
        island = new int[][]{
                {1, 0, 1, 1, 1},
        };
        MatrixCountIsland.printMatrix(island);
        System.out.println(String.format("Island count = %d", MatrixCountIsland.getIslandsBFSTabulate(island)));
    }
}
