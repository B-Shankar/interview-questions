package arrays_problems;

// 152. Maximum Product Subarray
public class MaximumProductSubarray {

    static public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                // swap because sign flips
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(curr, max * curr);
            min = Math.min(curr, min * curr);

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }
}
