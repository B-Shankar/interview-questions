package greedy_algo;

// Minimum cost to make array size 1 by removing larger of pairs

//Given an array of n integers. We need to reduce size of array to one. We are allowed to select a pair of integers and remove the larger one of these two. This decreases the array size by 1. Cost of this operation is equal to value of smallest one. Find out minimum sum of costs of operations needed to convert the array into a single element.

public class MinimumCost {

    int minCost(int[] arr, int n) {
        int min = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return (n - 1) * min;
    }

    public static void main(String[] args) {
        MinimumCost minimumCost = new MinimumCost();

        int[] arr = {4, 3, 2};
        int ans = minimumCost.minCost(arr, arr.length);
        System.out.println("ans: " + ans);
    }
}
