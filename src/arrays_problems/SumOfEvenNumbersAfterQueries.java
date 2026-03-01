package arrays_problems;

import java.util.Arrays;

// 985. Sum of Even Numbers After Queries
public class SumOfEvenNumbersAfterQueries {

    static public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int sumEven = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                sumEven += num;
        }

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            if (nums[idx] % 2 == 0) { // even
                sumEven -= nums[idx];
            }

            nums[idx] += val;

            if (nums[idx] % 2 == 0)
                sumEven += nums[idx];

            result[i] = sumEven;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[][] queries = {
            {1, 0},
            {-3, 1},
            {-4, 0},
            {2, 3}
        };

        System.out.println(Arrays.toString(sumEvenAfterQueries(nums, queries)));
    }
}
