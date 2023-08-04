package org.zealot.algorithm.warmup;

public class Sqrt {
    public static int solution(int number) {
        if (number < 2)
            return number;

        int newSqrt = 1;
        int newNumber = 1;
        while(newNumber < number){
            newSqrt = newSqrt + 1;
            newNumber = newSqrt * newSqrt;
        }

        return (newNumber == number) ? newSqrt : newSqrt-1;
    }
}
