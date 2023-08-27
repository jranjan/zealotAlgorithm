package org.zealot.algorithm.pattern.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSumOfGivenElementCount {
    public static double[] findAveragesBruteForce(int K, int[] arr) {
        List<Double> resultList = new ArrayList<Double>();
        for(int i=0; i<arr.length-K+1; i++) {
            double sum = arr[i];
            for(int j=i+1; j<i+K; j++) {
                sum = sum + arr[j];
            }
            double avg = sum / K;
            resultList.add(avg);
        }

        double[] doubleArray = new double[resultList.size()];
        for(int i=0;  i<resultList.size(); i++) {
            doubleArray[i] = resultList.get(i);
        }

        return doubleArray;
    }

    public static double[] findAveragesSlidingWindowNaive(int K, int[] arr){
        List<Double> resultList = new ArrayList<Double>();
        double sum = arr[0];
        for(int i=1; i<K; i++) {
            sum = sum + arr[i];
        }
        resultList.add(sum/K);

        // Now apply sliding window strategy
        for(int i=1; i<arr.length-K+1; i++) {
            sum = sum - arr[i-1] + arr[i+K-1];
            resultList.add(sum/K);
        }


        double[] doubleArray = new double[resultList.size()];
        for(int i=0;  i<resultList.size(); i++) {
            doubleArray[i] = resultList.get(i);
        }

        return doubleArray;
    }

    public static double[] findAveragesSlidingWindow(int K, int[] arr){
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return  result;
    }
}
