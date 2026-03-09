package arrays_problems;

// Maximum Sum Of Subarray
public class MaxSumOfSubarray {

    static int maxSumOfSubarray(int[] arr, int k) {
        int n = arr.length;

        int i = 0, j = 0;
        int sum = 0, max = Integer.MIN_VALUE;

        while (j < n) {
            sum += arr[j];

            int current_window_size = j - i + 1;
            if (current_window_size < k) {
                j++;
            } else if (current_window_size == k) {
                max = Math.max(sum, max);

                sum -= arr[i];
                i++;
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 8, 4, 9, 11};

        System.out.println(maxSumOfSubarray(arr, 3));
    }
}
