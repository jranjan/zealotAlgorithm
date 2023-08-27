package org.zealot.algorithm.pattern.matrix;

import java.util.Arrays;

public class IslandCount {
    public static int countIslandsBruteForce(int[][] matrix) {
        if (matrix.length == 0) return 0;
        if ((matrix.length == 1) && (matrix[0].length == 1) && (matrix[0][0] == 1)) return 1;

        int totalIslands = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0){
                    traverseRecursive(matrix, i, j);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
    }

    static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
    public static void traverseRecursive(int[][] matrix, int x, int y) {
        matrix[x][y] = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        // traverse all direction
        if (((x - 1) > 0) && (matrix[x-1][y]) != 0) traverseRecursive(matrix, x - 1, y);
        if (((x + 1) < row) && (matrix[x+1][y]) != 0) traverseRecursive(matrix, x + 1, y);
        if (((y - 1) > 0) && (matrix[x][y-1]) != 0) traverseRecursive(matrix, x, y - 1);
        if (((y + 1) < col) && (matrix[x][y+1]) != 0) traverseRecursive(matrix, x, y + 1);
    }
}
