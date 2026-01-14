package greedy_algo;

import java.util.ArrayList;
import java.util.Arrays;

// Minimum and Maximum Candy Cost
public class MaxMinCandyCost {
    static ArrayList<Integer> minMaxCandy(int[] prices, int k) {

        // Sort the array to arrange candies by price
        Arrays.sort(prices);

        // Calculate minimum cost by traversing
        // from beginning
        int n = prices.length;
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += prices[i];
            n -= k;
        }

        // Calculate maximum cost by traversing
        // from end
        int index = -1, maxCost = 0;
        for (int i = prices.length - 1; i > index; i--) {
            maxCost += prices[i]; // fixed here
            index += k;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4};
        int k = 2;
        ArrayList<Integer> res = minMaxCandy(prices, k);
        System.out.println(res.get(0) + " " + res.get(1));
    }
}

/*
Minimum and Maximum Candy Cost
Given an array prices[] of n different candies, where prices[i] represents the price of the ith candy and all prices are distinct. The store has an offer where for every candy you buy, you can get up to k other different candies for free. Find the minimum and maximum amount of money needed to buy all the candies.
Note: In both cases, you must take the maximum number of free candies possible during each purchase.

Examples:

Input: prices[] = [3, 2, 1, 4], k = 2
Output: [3, 7]
Explanation: For minimum cost, buy the candies costing 1 and 2. for maximum cost, buy the candies costing 4 and 3.

Input: prices[] = [3, 2, 1, 4, 5], k = 4
Output: [1, 5]
Explanation: For minimum cost, buy the candy costing 1. for maximum cost, buy the candy costing 5.
*/