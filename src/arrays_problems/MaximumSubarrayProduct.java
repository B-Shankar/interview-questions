package arrays_problems;

// 1567. Maximum Length of Subarray With Positive Product
public class MaximumSubarrayProduct {
    static public int getMaxLen(int[] nums) {
        int posLen = 0, negLen = 0;
        int result = 0;

        for (int num : nums) {
            if (num > 0) {
                posLen++;
                negLen = (negLen > 0) ? negLen + 1 : 0;
            } else if (num < 0) {
                int temp = posLen;
                posLen = (negLen > 0) ? negLen + 1 : 0;
                negLen = temp + 1;
            } else {
                posLen = 0;
                negLen = 0;
            }

            result = Math.max(result, posLen);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,-3,4};
        System.out.println(getMaxLen(arr));
    }
}
