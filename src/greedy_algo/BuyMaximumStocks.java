package greedy_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Buy Maximum Stocks if i stocks can be bought on i-th day

class Stocks {
    int price;
    int maxQty;

    public Stocks(int price, int maxQty) {
        this.maxQty = maxQty;
        this.price = price;
    }

}

public class BuyMaximumStocks {

    int buyMaximumProducts(int[] arr, int k) {

        List<Stocks> stocks = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            stocks.add(new Stocks(arr[i], i + 1));
        }

        System.out.println(Arrays.deepToString(stocks.toArray()));
        stocks.sort(Comparator.comparingInt(stock -> stock.price));

        int money = k;
        int totalStocks = 0;

        for (Stocks stock : stocks) {

            if (money <= 0)
                return 0;

            int canBuy = Math.min(stock.maxQty, money / stock.price);

            totalStocks += canBuy;
            money -= canBuy * stock.price;
        }

        return totalStocks;
    }

    public static void main(String[] args) {
        int k = 45;
        int[] arr = {10, 7, 19};

        BuyMaximumStocks buyMaximumStocks = new BuyMaximumStocks();
        int ans = buyMaximumStocks.buyMaximumProducts(arr, k);

        System.out.println("Max Stocks Brought: " + ans);
    }
}

/*
In a stock market, there is a product with its infinite stocks. The stock prices are given for N days, where arr[i] denotes the price of the stock on the ith day. There is a rule that a customer can buy at most i stock on the ith day. If the customer has k amount of money initially, find out the maximum number of stocks a customer can buy.

For example, for 3 days the price of a stock is given as 7, 10, 4. You can buy 1 stock worth 7 rs on day 1, 2 stocks worth 10 rs each on day 2 and 3 stock worth 4 rs each on day 3.

Examples:

Input : price[] = { 10, 7, 19 },
k = 45.
Output : 4
A customer purchases 1 stock on day 1 for 10 rs,
        2 stocks on day 2 for 7 rs each and 1 stock on day 3 for 19 rs.Therefore total of
10, 7 * 2 = 14 and 19 respectively. Hence,
total amount is 10 + 14 + 19 = 43 and number
of stocks purchased is 4.
*/