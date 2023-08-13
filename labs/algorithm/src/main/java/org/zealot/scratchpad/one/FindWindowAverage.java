package org.zealot.scratchpad.one;



import java.util.ArrayList;
import java.util.List;

public class FindWindowAverage {
    public static double[] average(int[] num, int k) {
        if ((k > num.length) || k <= 0) return null;

        List<Double> dl = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + num[i];
        }
        dl.add((double) (sum) / k);

        for (int j = k; j < num.length; j++) {
            // Remove the element from sum which is going out of window
            sum = sum - num[j-k];
            // Add new element
            sum = sum + num[k];
            dl.add((double) (sum) / k);
        }

        double[] dlArray = new double[dl.size()];
        for (int i = 0; i < dlArray.length; i++) {
            dlArray[i] = dl.get(i);
        }
        return dlArray;
    }
}
