package org.zealot.algorithm.scratchpad.one;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.scratchpad.one.BacktrackFindBoardWord;

public class BacktrackFindBoardWordTest {
    @Test
    void searchExistence() {
        char[][] board = {
              { 'A', 'B', 'C', 'E' },
              { 'S', 'F', 'C', 'S' },
              { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(String.format("Word=[%s] exists? %b", word,
              BacktrackFindBoardWord.exists(board, word)));

        word = "BCCED";
        System.out.println(String.format("Word=[%s] exists? %b", word,
                BacktrackFindBoardWord.exists(board, word)));

        word = "ACED";
        System.out.println(String.format("Word=[%s] exists? %b", word,
                BacktrackFindBoardWord.exists(board, word)));

        word = "BFCE";
        System.out.println(String.format("Word=[%s] exists? %b", word,
                BacktrackFindBoardWord.exists(board, word)));

        word = "BFCEAB";
        System.out.println(String.format("Word=[%s] exists? %b", word,
                BacktrackFindBoardWord.exists(board, word)));
  }
}
