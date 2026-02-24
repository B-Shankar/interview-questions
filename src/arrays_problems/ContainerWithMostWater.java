package arrays_problems;

// 11. Container With Most Water
public class ContainerWithMostWater {

    static int maxArea(int[] height) {
        int n = height.length;

        int maxWater = 0;

        int i = 0, j = n - 1;

        while (i < j) {
            int w = j - i;
            int h = Math.min(height[i], height[j]);

            int area = w * h;

            maxWater = Math.max(maxWater, area);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }

        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
