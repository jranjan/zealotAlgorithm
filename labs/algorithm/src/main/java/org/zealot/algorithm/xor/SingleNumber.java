package xor;

import org.junit.jupiter.api.Test;

public class SingleNumber {

    public static int single(int[] arr) {
        int r = arr[0];
        for(int j=1; j<arr.length; j++)
            r = r ^ arr[j];
        return r;
    }
}
