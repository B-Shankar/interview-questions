package greedy_algo;

import java.util.ArrayList;
import java.util.List;

// Minimum Fibonacci terms with sum equal to K
public class MinimumFibonacciNums {

    private static int minimumFibonacciTerms(int k) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);

        // Generate Fibonacci numbers up to k
        while (fib.get(fib.size() - 1) < k) {
            fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
        }

        int count = 0;

        // Start from the largest Fibonacci number
        for (int i = fib.size() - 1;
             i >= 0 && k > 0; i--) {

            // Use the largest possible Fibonacci number
            while (k >= fib.get(i)) {
                k -= fib.get(i);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int k = 7;

        System.out.println(minimumFibonacciTerms(k));
    }

}

/*
Given a number k, the task is to find the minimum number of Fibonacci terms (including repetitions) whose sum equals k.
Note: You may use any Fibonacci number multiple times.

Examples:

Input: k = 7
Output: 2
Explanation: Possible ways to sum up to 7 using Fibonacci numbers:
5 + 2 = 7 (2 terms)
3 + 3 + 1 = 7 (3 terms)
2 + 2 + 2 + 1 = 7 (4 terms)
The minimum number of terms is 2, using 5 + 2.

Input: k = 13
Output: 1
Explanation: Possible ways to sum up to 13 using Fibonacci numbers:
13 = 13 (1 term)
8 + 5 = 13 (2 terms)
Using 13 directly gives the minimum number of terms, which is 1.
*/