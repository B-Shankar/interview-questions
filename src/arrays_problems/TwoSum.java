package arrays_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. Two Sum
public class TwoSum {

    // Time Complexity: O(n), Space Complexity: O(n)
    public static int[] twoSum(int[] nums, int target) {

        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {

            int newNum = target - nums[i];

            if (map.containsKey(newNum)) {
                return new int[]{i, map.get(newNum)};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
