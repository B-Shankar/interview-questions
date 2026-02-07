package arrays_problems;

import java.util.Arrays;

// 3634. Minimum Removals to Balance Array
public class MinimumRemovalsToBalanceArray {

    /*
    Constraints:
        1 <= arr.length <= 10^5
        1 <= arr[i] <= 10^9
        1 <= k <= 10^5

        From constraints, solution need O(n * log n) or less. O(n^2) is not possible.
    */

    // Complexity : O (n * log n) + 2 * O(n)
    // Complexity: O (n * log n)    // avoiding constant + lower values

    // Why 2 * O(n) : each elements is visited twice (one i, one j). So, 2*O(n)
    public static int minRemoval(int[] arr, int k) {
        int n = arr.length;
        int L = 1;

        Arrays.sort(arr); // O(n * log n)

        long maxEl = arr[0];
        long minEl = arr[0];

        int i = 0, j = 0;

        while (j < n) {             // O(n)
            minEl = arr[i];
            maxEl = arr[j];

            while (i < j && maxEl > k * minEl) {    // O(n)
                i++;
                minEl = arr[i];
            }

            L = Math.max(L, j - i + 1);
            j++;
        }

        return n - L;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5};
        int[] arr1 = {1, 6, 2, 9};

        System.out.println("min deletion of elements: " + minRemoval(arr, 2));
        System.out.println("min deletion of elements: " + minRemoval(arr1, 3));
    }
}
