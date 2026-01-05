package greedy_algo;

//Let's say you have a set of coins with values [1, 2, 5, 10] and you need to give minimum number of coin to someone change for 39.

import java.util.Arrays;

public class CoinBasedQuestion {

//    The greedy algorithm for making change would work as follows:
//
//    Step-1: Start with the largest coin value that is less than or equal to the amount to be changed. In this case, the largest coin less than or equal to 39 is 10.
//    Step- 2: Subtract the largest coin value from the amount to be changed, and add the coin to the solution. In this case, subtracting 10 from 39 gives 29, and we add one 10-coin to the solution.
//    Repeat steps 1 and 2 until the amount to be changed becomes 0.


    int minCoins(int[] coins, int amount) {
        int n = coins.length;
        int min_coins = 0;

        Arrays.sort(coins);

        for (int i = n - 1; i >= 0; i--) {
            if (amount >= coins[i]) {

                int count = (amount / coins[i]);

                min_coins += count;

                amount -= (count * coins[i]);
            }

            if (amount == 0) break;
        }

        return min_coins;
    }


    public static void main(String[] args) {
        CoinBasedQuestion coinClass = new CoinBasedQuestion();

        int[] coins = {1, 2, 5, 10};
        int amount = 39;
        int minCoins = coinClass.minCoins(coins, amount);

        System.out.println("Min coin need to return is: " + minCoins + " for exchange amount: " + amount);
    }
}
