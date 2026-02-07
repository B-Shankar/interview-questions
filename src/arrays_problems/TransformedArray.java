package arrays_problems;

import java.util.Arrays;

// 3379. Transformed Array
public class TransformedArray {

    public static int[] toTransformedArray(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int shift = nums[i] % n; // reduing large shift to 0..n-1 range

            int newIdx = (i + shift) % n;  // %n for handling out of bound

            if (newIdx < 0) {
                newIdx += n;
            }

            result[i] = nums[newIdx];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,-2,1,1};

        System.out.println("result: " + Arrays.toString(toTransformedArray(nums)));
    }
}
