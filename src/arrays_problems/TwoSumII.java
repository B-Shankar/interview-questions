package arrays_problems;

import java.util.Arrays;

// 167. Two Sum II - Input Array Is Sorted
public class TwoSumII {

    public static int[] twoSumII(int[] nums, int target) {

        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] < target)
                i++;
            else
                return (i + 1 >= 1 && j + 1 <= nums.length) ?
                        new int[]{i + 1, j + 1} : new int[]{-1, -1};
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        System.out.println(Arrays.toString(twoSumII(nums, 9)));
    }
}
