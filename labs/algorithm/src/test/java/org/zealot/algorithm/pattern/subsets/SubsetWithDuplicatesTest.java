package org.zealot.algorithm.pattern.subsets;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.subsets.SubsetWithDuplicates;

public class SubsetWithDuplicatesTest {
   @Test
   void findDistinctSubset(){
       int[] num1 = new int[]{1, 3, 3};
       System.out.println(SubsetWithDuplicates.findSubsets(num1).toString());
       int[] num2 = new int[]{1, 5, 3, 3};
       System.out.println(SubsetWithDuplicates.findSubsets(num2).toString());
   }
    @Test
    void findDistinctSubsetSmart(){
        int[] num1 = new int[]{1, 3, 3};
        System.out.println(SubsetWithDuplicates.findSubsetsSmartway(num1).toString());
        int[] num2 = new int[]{1, 5, 3, 3};
        System.out.println(SubsetWithDuplicates.findSubsetsSmartway(num2).toString());
    }
}
