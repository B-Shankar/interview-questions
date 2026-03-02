package arrays_problems;

// 724. Find Pivot Index
// GFG: Equilibrium Index/Point
public class FindPivotIndex {

    // Time Complexity: O(n)
    static int pivotIndex(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int cs = 0; // cumulative sum
        for (int i = 0; i < n; i++) {
            int ls = cs; // left sum
            int rs = sum - cs - nums[i]; // right sum

            if (ls == rs)
                return i;

            cs += nums[i];
        }

        return -1;
    }

    // Time Complexity & Space Complexity: O(n)
    static int pivotIndex1(int[] nums) {
        int n = nums.length;

        int[] store = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            store[i] = sum;
        }


        for (int i = 0; i < n; i++) {
            int ls = store[i] - nums[i];
            int rs = sum - ls - nums[i];

            if (ls == rs)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(pivotIndex1(arr));
    }
}
