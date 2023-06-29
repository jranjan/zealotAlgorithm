package org.zealot.algorithm.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoodPairTest {
    @Test
    void chckGoodPairs() {
        int[] numsSet1 = new int[]{1,2,3,1,1,3};
        assertTrue(GoodPair.solution(numsSet1) == 4);
        int[] numsSet2 = new int[]{1,1,1,1};
        assertTrue(GoodPair.solution(numsSet2) == 6);
        int[] numsSet3 = new int[]{1,2,3};
        assertTrue(GoodPair.solution(numsSet3) == 0);
    }

    @Test
    void chckGoodPairsWithoutSort() {
        int[] numsSet1 = new int[]{1,2,3,1,1,3};
        assertTrue(GoodPair.solutionWithoutSort(numsSet1) == 4);
        int[] numsSet2 = new int[]{1,1,1,1};
        assertTrue(GoodPair.solutionWithoutSort(numsSet2) == 6);
        int[] numsSet3 = new int[]{1,2,3};
        assertTrue(GoodPair.solutionWithoutSort(numsSet3) == 0);
    }

    @Test
    void chckGoodPairsHashmap() {
        int[] numsSet1 = new int[]{1,2,3,1,1,3};
        assertTrue(GoodPair.solutionHashmap(numsSet1) == 4);
        int[] numsSet2 = new int[]{1,1,1,1};
        assertTrue(GoodPair.solutionHashmap(numsSet2) == 6);
        int[] numsSet3 = new int[]{1,2,3};
        assertTrue(GoodPair.solutionHashmap(numsSet3) == 0);
    }
}
