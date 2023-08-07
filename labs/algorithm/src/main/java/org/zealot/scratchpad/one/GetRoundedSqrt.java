package org.zealot.scratchpad.one;

public class GetSqrt {
    public static int algorithmUsingLoop(int n) {
        int sqrt = 0;
        while((sqrt*sqrt) < n) {
            sqrt++;
        }
        return (sqrt*sqrt > n) ? sqrt - 1 : sqrt;
    }
}
