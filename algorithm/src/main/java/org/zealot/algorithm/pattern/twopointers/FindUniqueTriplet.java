package org.zealot.algorithm.pattern.twopointers;

import java.util.*;

// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
public class FindUniqueTriplet {
    public static List<List<Integer>> solution(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if (0 == sum) {
                        // uniqueness passed, so add it!
                        ArrayList<Integer> match = new ArrayList<>();
                        match.add(arr[i]);
                        match.add(arr[j]);
                        match.add(arr[k]);
                        boolean bAdd = true;
                        Collections.sort(match);
                        for (int pos=0; pos<triplets.size(); pos++) {
                            ArrayList<Integer> curr = (ArrayList<Integer>) triplets.get(pos);
                            if (true == Arrays.equals(match.toArray(), curr.toArray())){
                                bAdd = false;
                                break;
                            }
                        }
                        if (bAdd) {
                            triplets.add(match);
                        }
                    }
                }
            }
        }

        return triplets;
    }

    public static List<List<Integer>> solutionTargetSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            int j=i+1;
            int k=arr.length-1;
            if (i>0) {
                if (arr[i] == arr[i-1]) {
                    continue;
                }
            }
            while (j<k){
                int targetSum = arr[j] + arr[k] + arr[i];
                if (j>i+1){
                    if (arr[j] == arr[j-1]) {
                        j++;
                        continue;
                    }
                }
                if (targetSum > 0) {
                    k--;
                } else if (targetSum < 0) {
                    j++;
                } else {
                    // hit the bulls eye
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    // we are not finding first triplet but all triplet. So, continue searching
                    // as there may be another set which can yield the same result. Think of
                    // a straight line where we are moving in increasing slope where first
                    // set match the goal but there will be another set in between these two
                    // numbers.
                    j++;
                }
            }
        }

        return result;
    }
}
