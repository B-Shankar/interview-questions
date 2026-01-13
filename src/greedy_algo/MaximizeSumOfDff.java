package greedy_algo;

// Maximize sum of consecutive differences in a circular array

import java.util.Arrays;

/*
Given an array of n elements. Consider array as circular array i.e element after an is a1. The task is to find maximum sum of the difference between consecutive elements with rearrangement of array element allowed i.e after rearrangement of element find |a1 - a2| + |a2 - a3| + ...... + |an - 1 - an| + |an - a1|.

Examples:

Input : arr[] = { 4, 2, 1, 8 }
Output : 18
Rearrange given array as : { 1, 8, 2, 4 }
Sum of difference between consecutive element
= |1 - 8| + |8 - 2| + |2 - 4| + |4 - 1|
= 7 + 6 + 2 + 3
= 18.

Input : arr[] = { 10, 12, 15 }
Output : 10
*/
public class MaximizeSumOfDff {

    private static int maxSum(int[] arr, int n) {
        int sum = 0;

        // Sorting the array.
        Arrays.sort(arr);

        for (int i = 0; i < n/2; i++)
        {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 1, 8 };
        int n = arr.length;
        System.out.println(maxSum(arr, n));
    }
}
