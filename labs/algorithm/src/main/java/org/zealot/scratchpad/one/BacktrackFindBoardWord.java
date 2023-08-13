package org.zealot.scratchpad.one;

public class BacktrackFindBoardWord {
    public static boolean exists(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = search(board, i, j, word, 0);
                    if (result == true) return true;
                }
            }
        }

        return false;
    }

    public static boolean search(char[][] board, int r, int c, String word, int pos) {
        if (!validPosition(board, r, c)) return false;
        if (pos == word.length() - 1) return true;

        if (board[r][c] == word.charAt(pos)) {
            boolean exists = search(board, r - 1, c, word, pos + 1) ||
            search(board, r + 1, c, word, pos + 1) ||
            search(board, r, c - 1, word, pos + 1) ||
            search(board, r, c + 1, word, pos + 1);

            return ((exists == true) ? true : false);
        }

        return false;
    }

    public static boolean validPosition(char[][] board, int x, int y) {
        boolean bResult = false;
        if (((x >= 0) && (x < board.length)) &&
                ((y >= 0) && (y < board[0].length))) {
            bResult = true;
        }
        return bResult;
    }
}
