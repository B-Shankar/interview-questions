package greedy_algo;

// Smallest subset sum greater than all others

import java.util.Arrays;

/*
Given an array of non-negative integers, the task is to find the minimum number of elements such that their sum should be greater than the sum of the rest of the elements of the array.

Example:

Input: arr[] = [ 3 , 1 , 7, 1 ]
Output: 1
Explanation: Smallest subset is {7}. Sum of this subset is greater than the sum of all other elements left after removing subset {7} from the array

Input:  arr[] = [ 2 , 1 , 2 ]
Output: 2
Explanation: Smallest subset is {2 , 1}. Sum of this subset is greater than the sum of all other elements left after removing subset {2 , 1} from the array
*/
public class SmallestSubset {

    int minElements(int[] arr) {

        int halfSum = 0;

        // Calculating HALF of array sum
        for (int i : arr)
            halfSum += arr[i];

        halfSum /= 2;

        // Sort the array in ascending order and
        // start traversing array from the ascending
        // sort in descending order.
        Arrays.sort(arr);

        int res = 0, current_sum = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            current_sum += arr[i];
            res++;

            // Current sum greater than sum
            if (current_sum > halfSum)
                return res;
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestSubset smallestSubset = new SmallestSubset();

        int[] arr = { 2, 1, 2 };

        int ans  = smallestSubset.minElements(arr);
        System.out.println("ans: " + ans);
    }

}
