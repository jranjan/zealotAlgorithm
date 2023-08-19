package org.zealot.algorithm.pattern.backtracking;

public class WordSearch {
    public static boolean search(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for(int j = 0; j < row.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    return backtrack(board, i, j, -1, -1, word);
                }
            }
        }
        return false;
    }

    public static boolean searchClean(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for(int j = 0; j < row.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    return backtrackClean(board, i, j, 0, word);
                }
            }
        }
        return false;
    }

    public static boolean backtrackClean(char[][] board, int currX, int currY, int k, String word) {
        if ((validPositionClean(board, currX, currY) == false) || (board[currX][currY] != word.charAt(k))) {
            return false;
        }

        // check if we have reached the end of the word
        if (k == word.length() - 1) {
            return true;
        }

        // mark the current cell as visited by replacing it with '/'
        // The special character bluffs even if we try to compare it from the position where we started
        // as it is not going to match. Awesome!
        char tmp = board[currX][currY];
        board[currX][currY] = '/';

        boolean res = backtrackClean(board, currX + 1, currY, k + 1, word) ||
                backtrackClean(board, currX - 1, currY, k + 1, word) ||
                backtrackClean(board, currX, currY + 1, k + 1, word) ||
                backtrackClean(board, currX, currY - 1, k + 1, word);

        // backtrack by replacing the current cell with its original value
        board[currX][currY] = tmp;
        return res;
    }

    public static boolean backtrack(char[][] board, int currX, int currY, int prevX, int prevY, String word) {
        if (validPosition(board, currX, currY, prevX, prevY) == false) {
            return false;
        }

        if (board[currX][currY] == word.charAt(0)) {
            if (word.length() == 1) return true;
            return  (backtrack(board, currX-1, currY, currX, currY, word.substring(1)) ||
                    backtrack(board, currX+1, currY, currX, currY, word.substring(1)) ||
                    backtrack(board, currX, currY-1, currX, currY, word.substring(1)) ||
                    backtrack(board, currX, currY+1, currX, currY, word.substring(1)));
        }

        return false;
    }

    public static boolean validPositionClean(char[][] board, int posX, int posY) {
        if ((posX >=0) && posX < (board.length)) {
            if ((posY >= 0) && posY < (board[posX].length)) return true;
        }
        return false;
    }
    public static boolean validPosition(char[][] board, int posX, int posY, int prevX, int prevY) {
        if ((posX >=0) && posX < (board.length)) {
            char[] row = board[posX];
            if ((posY >= 0) && posY < (row.length)) {
                if ((posX != prevX) || (posY != prevY)) {
                    return true;
                }
            }
        }
        return false;
    }
}
