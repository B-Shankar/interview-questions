package arrays_problems;

import java.util.Arrays;

// 239. Sliding Window Maximum
public class SlidingWindowMaximum {

    // Time complexity: O(n * k)
    static public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;

        int[] result = new int[n - k + 1];
        int idx = 0;

        while (j < n) {
            // calculation
            int val = nums[j];
            max = Math.max(val, max);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // condition
                result[idx++] = max;

                if (max == nums[i]) {
                    max = Integer.MIN_VALUE;
                    for (int start = i+1; start <= j; start++) {
                        max = Math.max(max, nums[start]);
                    }
                }

                // slid window
                j++;
                i++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
