package org.zealot.algorithm.pattern.knapsack;

import java.util.ArrayList;
import java.util.List;

public class ProfitForDivisableObject {
   public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
      List<Integer> selection = new ArrayList<>();
      List<Double> profitsWeightRatio = new ArrayList<>();
      for(int i = 0; i < profits.length; i++) {
         profitsWeightRatio.add((double)profits[i]/ (double) weights[i]);
      }

      int newCapacity = 0;
      int maxProfit = 0;
      int iterationCount = 0;
      while ((newCapacity < capacity) && (iterationCount < weights.length)) {
         // pick the highest profitable piece
         int maxProfitablePos = -1;
         double maxProfitWeightage = 0.0;
         for(int j = 0; j < profitsWeightRatio.size(); j++) {
            if (Double.compare(profitsWeightRatio.get(j), maxProfitWeightage) > 0) {
               maxProfitWeightage = profitsWeightRatio.get(j);
               maxProfitablePos = j;
            }
         }

         if (maxProfitablePos != -1) {
            if ((newCapacity + weights[maxProfitablePos]) <= capacity) {
               maxProfit = maxProfit + profits[maxProfitablePos];
               selection.add(maxProfitablePos);
               newCapacity = newCapacity + weights[maxProfitablePos];
            }

            profitsWeightRatio.set(maxProfitablePos, 0.0);
         }
         iterationCount++;
      }

      System.out.println(selection);
      return maxProfit;
   }
}
