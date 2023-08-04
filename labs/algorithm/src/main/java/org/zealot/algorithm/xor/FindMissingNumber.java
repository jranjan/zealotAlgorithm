package xor;

// The XOR trick: If we have a sequence of XOR operations a ^ b ^ c ^ ...,
// then we can remove all pairs of duplicated values without affecting the result.
// Commutativity allows us to re-order the applications of XOR so that the
// duplicated elements are next to each other. Since x ^ x = 0 and a ^ 0 = a,
// each pair of duplicated values has no effect on the outcome.
public class FindMissingNumber {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        // find XOR of all numbers from 1 to n.
        // Doing so will give me a result which ensure that no number is duplicate
        // Doing so ensures that we have took an impression of all numbers from 1..N

        // This will give us a sequence of XOR statements where elements appear as follows:

        // ll values in the given list now appear twice:
        // once from taking all the values between 1 and n
        // once because they were in the original list
        // The missing value appears exactly once:
        // once from taking all the values between 1 and n
        int x1 = 1;
        for (int i = 2; i <= n; i++) {
            x1 = x1 ^ i;
        }

        // x2 represents XOR of all values in arr
        // Doing so we have taken impressin of all numbers except missing one
        int x2 = arr[0];
        for (int i = 1; i < n-1; i++)
            x2 = x2 ^ arr[i];

        // missing number is the xor of x1 and x2
        return x1 ^ x2;
    }

}
