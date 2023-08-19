package org.zealot.algorithm.scratchpad.one;

/******************************************************************************************************
 * Analysis Syntax =  Readiness | Popularity | Code Knowledge | Analysis Knowledge | Strategy
 * Analysis = RUN | HIGH | EXCELLENT | EXCELLENT | REVISIT
 *****************************************************************************************************/
public class GetRoundedSqrt {
    public static int algorithmUsingLoop(int n) {
        int sqrt = 0;
        while((sqrt*sqrt) < n) {
            sqrt++;
        }
        return (sqrt*sqrt > n) ? sqrt - 1 : sqrt;
    }

    public static int algorithimUsingBinarySearch(int n) {
        if (n < 0) return -1;
        if ((n >= 0) && ( n <= 1)) return  n;

        // The square root of a number has to lie between 1..n/2.
        // Remember this man! Remember this!
        int left = 1;
        int right = n / 2;
        int pivot = - 1;
        while(left <= right) {
            pivot = (left + right ) / 2;
            long currentNumber = pivot * pivot;
            if (currentNumber > n) {
                right = pivot - 1;
            } else if (currentNumber < n){
                left = pivot + 1;
            } else {
                return  pivot;
            }
        }

        // Return right as left is greater than the number
        return right;
    }
}
