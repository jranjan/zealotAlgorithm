package org.zealot.algorithm.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WordSearchTest {

    @Test
    void searchWord(){
        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        System.out.println("searchWord - Found (ABCCED) : " + WordSearch.search(board1, "ABCCED"));
        System.out.println("searchWord - Found (BCCED) : " + WordSearch.search(board1, "BCCED"));
        System.out.println("searchWord - Found (ACED) : " + WordSearch.search(board1, "ACED"));
        System.out.println("searchWord - Found (BFCE) : " + WordSearch.search(board1, "BFCE"));
    }

    @Test
    void searchWordClean(){
        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        System.out.println("searchWordClean - Found (ABCCED) : " + WordSearch.searchClean(board1, "ABCCED"));
        System.out.println("searchWordClean - Found (BCCED) : " + WordSearch.searchClean(board1, "BCCED"));
        System.out.println("searchWordClean - Found (ACED) : " + WordSearch.searchClean(board1, "ACED"));
        System.out.println("searchWordClean - Found (BFCE) : " + WordSearch.searchClean(board1, "BFCE"));
    }
}
