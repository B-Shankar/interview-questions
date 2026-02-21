package arrays_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum
public class ThreeSum {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return result;

        result.clear();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int n1 = nums[i];
            int target = -n1;

            twoSum(nums, target, i + 1, n - 1);
        }

        return result;
    }

     static void twoSum(int[] nums, int target, int i, int j) {
        while (i < j) {

            if (nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] < target)
                i++;
            else {
                while(i < j && nums[i] == nums[i + 1]) i++;

                while (j > i && nums[j] == nums[j - 1]) j--;

                result.add(new ArrayList<>(Arrays.asList(-target, nums[i], nums[j])));
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }
}
