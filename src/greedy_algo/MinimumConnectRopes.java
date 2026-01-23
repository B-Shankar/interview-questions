package greedy_algo;

import java.util.Arrays;

// Connect n ropes with minimum cost
public class MinimumConnectRopes {

    private static int minCost(int[] arr) {
        int totalCost = 0;
        int n = arr.length;

        // Continue until only one rope remains
        while (n > 1) {

            // Sort ropes to get the two smallest lengths
            Arrays.sort(arr, 0, n);

            // Pick the two smallest ropes
            int first = arr[0];
            int second = arr[1];

            // Cost of connecting these two ropes
            int cost = first + second;
            totalCost += cost;

            // Shift the array to remove the two smallest elements
            for (int i = 2; i < n; i++) {
                arr[i - 2] = arr[i];
            }

            // Place the new rope at the end
            arr[n - 2] = cost;

            // Reduce array size by 1 (two removed, one added)
            n--;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println(minCost(ropes));
    }
}

/*
Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths.

Examples:

Input: arr[] = [4, 3, 2, 6]
Output: 29
Explanation:  Minimum cost to connect all ropes into a single rope is
Connect ropes 2 and 3 - [4, 5, 6], cost = 5
Connect ropes 4 and 5 - [9, 6], cost = 9
Connect ropes 9 and 6 - [15], cost = 15
Total cost = 5 + 9 + 15 = 29

*/