package arrays_problems;

// 42. Trapping Rain Water
public class TrappingRainWater {

    // Time Complexity: O(n); Space Complexity: O(n)
    public static int trap(int[] height) {
        int n = height.length;
        int sum = 0;

        int[] leftMax = getLeftMaxArray(height, n); // O(n)
        int[] rightMax = getRightMaxArray(height, n); // O(n)

        // O(n)
        for (int i = 0; i < n; i++) {
            int width = 1;

            int h = Math.min(leftMax[i], rightMax[i]) - height[i];

            sum += (h * width);
        }

        return sum;
    }

    // O(n)
    public static int[] getLeftMaxArray(int[] height, int n) {

        int[] leftMax = new int[n];

        //left most
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        return leftMax;
    }

    // O(n)
    public static int[] getRightMaxArray(int[] height, int n) {

        int[] rightMax = new int[n];

        // right most
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        return rightMax;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5}; // {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }
}
