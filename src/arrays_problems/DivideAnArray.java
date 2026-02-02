package arrays_problems;

// 3010. Divide an Array Into Subarrays With Minimum Cost I
public class DivideAnArray {

    private static int minCost(int[] nums) {
        int result = nums[0];
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }

        return (result + firstMin + secondMin);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,12};

        System.out.println("Min Cost: " + minCost(nums));
    }
}
