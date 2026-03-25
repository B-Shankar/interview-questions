package arrays_problems;

import java.util.Arrays;

// 977. Squares of a Sorted Array
public class SquaresOfSortedArray {

    static public int[] sortedArray(int[] nums) {
        int n = nums.length;

        int i = 0, j = n - 1;

        int[] result = new int[n];
        int index = n - 1;
        while (j >= i) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[index--] = nums[i] * nums[i];
                i++;
            } else {
                result[index--] = nums[j] * nums[j];
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedArray(arr)));
    }
}
