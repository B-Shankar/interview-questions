package arrays_problems;

import java.lang.reflect.Array;
import java.util.Arrays;

// 645. Set Mismatch
public class SetMismatch {

    static int[] setMismatch(int[] nums) {
        int n = nums.length;

        int dup = -1, missing = -1;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);

            if (nums[val - 1] < 0) {
                dup = val;
            } else {
                nums[val - 1] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};

        System.out.println(Arrays.toString(setMismatch(arr)));
    }
}
