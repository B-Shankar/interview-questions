package greedy_algo;

import java.util.Arrays;

public class FractionalKnapsackNoComparator {

    static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        // items[i][0] = value
        // items[i][1] = weight
        // ratio[i]    = value / weight
        double[] ratio = new double[n];
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
            ratio[i] = (1.0 * val[i]) / wt[i];
        }

        // Manual sorting by ratio (DESCENDING)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (ratio[i] < ratio[j]) {
                    // swap ratio
                    double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;

                    // swap corresponding items
                    int tempVal = items[i][0];
                    int tempWt = items[i][1];

                    items[i][0] = items[j][0];
                    items[i][1] = items[j][1];

                    items[j][0] = tempVal;
                    items[j][1] = tempWt;
                }
            }
        }

        System.out.println("Sorted Items: " + Arrays.deepToString(items));
        System.out.println("Sorted Ratio: " + Arrays.toString(ratio));

        double res = 0.0;
        int currentCapacity = capacity;

        // Greedy selection
        for (int i = 0; i < n; i++) {

            if (items[i][1] <= currentCapacity) {
                res += items[i][0];
                currentCapacity -= items[i][1];
            } else {
                res += ratio[i] * currentCapacity;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        System.out.println("Max Value = " + fractionalKnapsack(val, wt, capacity));
    }
}
