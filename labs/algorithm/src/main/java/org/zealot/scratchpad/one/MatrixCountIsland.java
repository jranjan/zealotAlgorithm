package org.zealot.scratchpad.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = CRAWL | HIGH | EXCELLENT | EXCELLENT | REVISIT
 *****************************************************************************************************/
public class MatrixCountIsland {
    public static int getIslandsDFS(int[][] matrix) {
        int islandCount = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // No point in starting if there is no 1s
                if (matrix[i][j] != 1) continue;
                // Mark or find the biggest island
                int ones = visitIslandDFS(matrix, i, j);
                islandCount = islandCount + ((ones != 0) ? 1 : 0);
            }
        }
        return islandCount;
    }
    public static int getIslandsBFS(int[][] matrix) {
        int islandCount = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // No point in starting if there is no 1s
                if (matrix[i][j] != 1) continue;
                // Mark or find the biggest island
                int ones = visitIslandBFS(matrix, i, j);
                islandCount = islandCount + ((ones != 0) ? 1 : 0);
            }
        }
        return islandCount;
    }

    public static int  getIslandsBFSTabulate(int[][] matrix) {
        int islandCount = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // No point in starting if there is no 1s
                if (!visited[i][j] && matrix[i][j] == 1) {
                    // we have found an island
                    islandCount++;
                    visitIslandBFSTabulate(matrix, visited, i, j);
                }
            }
        }
        return islandCount;
    }

    public static int visitIslandBFSTabulate(int[][] matrix, boolean[][] visited, int x, int y) {
        Queue<int[]> neighbors = new LinkedList<>();
        neighbors.add(new int[] { x, y });
        int count = 0;
        while (!neighbors.isEmpty()) {
            int row = neighbors.peek()[0];
            int col = neighbors.peek()[1];
            neighbors.remove();

            if (!checkIslandSanity(matrix, row, col)) continue; // continue, if it is not a valid cell
            if (matrix[row][col] == 0 || visited[row][col])
                continue; // continue if the cell is water or visited

            visited[row][col] = true; // mark the visited array
            count++;

            // insert all neighboring cells to the queue for BFS
            neighbors.add(new int[] { row + 1, col }); // lower cell
            neighbors.add(new int[] { row - 1, col }); // upper cell
            neighbors.add(new int[] { row, col + 1 }); // right cell
            neighbors.add(new int[] { row, col - 1 }); // left cell
        }
        return count;
    }

    public static int visitIslandBFS(int[][] matrix, int rowPos, int colPos) {
        Queue<int[]> neighbors = new LinkedList<>();
        neighbors.add(new int[] { rowPos, colPos });
        int count = 0;
        while (!neighbors.isEmpty()) {
            // Get the element
            int[] cell = neighbors.remove();
            int r = cell[0];
            int c = cell[1];

            if (!checkIslandSanity(matrix, r, c)) continue;

            // Water cell, continue
            if (matrix[r][c] != 1) continue;
            // Land is there, mark it
            matrix[r][c] = 0;
            count++;

            // Let us add the neighbours, all four! Like we used to add two for binary tree, we will do
            // add four here as there are four neighbours. Think it as node with 4 children, some
            // may be invalid, some maybe valid.
            neighbors.add(new int[] { r - 1, c});
            neighbors.add(new int[] { r + 1, c});
            neighbors.add(new int[] { r, c - 1});
            neighbors.add(new int[] { r, c + 1});
        }

        return count;
    }

    public static int visitIslandDFS(int[][] matrix, int rowPos, int colPos) {
        // Base condition
        if (!checkIslandSanity(matrix, rowPos, colPos)) return 0;
        if (matrix[rowPos][colPos] == 0) return 0;

        // Mark as traversed
        matrix[rowPos][colPos] = 0;

        // Traverse in all four direction
        int count =  1 + visitIslandDFS(matrix, rowPos-1, colPos) +
                visitIslandDFS(matrix, rowPos+1, colPos) +
                visitIslandDFS(matrix, rowPos, colPos-1) +
                visitIslandDFS(matrix, rowPos, colPos+1);

        return count;
    }

    public static boolean checkIslandSanity(int[][] matrix, int rowPos, int colPos) {
        if (((rowPos >= 0) && (rowPos < matrix.length)) &&
                ((colPos >= 0) && (colPos < matrix[0].length))) {
            return true;
        }
        return false;
    }

    static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
