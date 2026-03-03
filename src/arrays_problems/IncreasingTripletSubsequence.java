package arrays_problems;

// 334. Increasing Triplet Subsequence
public class IncreasingTripletSubsequence {

    static boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num3 = nums[i];

            if (num3 <= num1) {
                num1 = num3;
            } else if (num3 <= num2) {
                num2 = num3;
            } else {
                // num1 < num2 < num3
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(arr));
    }
}
