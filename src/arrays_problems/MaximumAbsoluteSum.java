package arrays_problems;

// 1749. Maximum Absolute Sum of Any Subarray
public class MaximumAbsoluteSum {

    static public int maxAbsoluteSum(int[] nums) {
        int maxEnding = 0, minEnding = 0;
        int result = 0;

        for (int num : nums) {
            maxEnding = Math.max(num, maxEnding + num);
            minEnding = Math.min(num, minEnding + num);

            result = Math.max(result, Math.max(maxEnding, Math.abs(minEnding)));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,-3,2,3,-4};

        System.out.println(maxAbsoluteSum(arr));
    }
}
