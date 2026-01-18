package greedy_algo;

// Minimum Number of jumps to reach end using Greedy
public class MiniNumJumps {
    static int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1) return 0;
        if (arr[0] == 0) return -1;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {

            if (i == n - 1) return jumps;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;

                if (i >= maxReach) return -1;

                steps = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 2, 1, 4, 6 };
        System.out.println(minJumps(arr));
    }
}

/*
Minimum Number of jumps to reach end using Greedy
Given an array arr[] where each element represents the maximum number of steps you can move forward from that position. Find the minimum number of jumps required to reach the last index, if you are starting from the 0th index.

Note: If it is not possible to reach the last index, return -1.

Input: arr[] = [1, 3, 2, 2, 1, 4, 6]
Output: 4
Explanation: Starting at index 0, we jump to index 1. From there, we move to index 4, then to index 5, and from index 5 we jump to index 6. So the minimum jumps needed are 4.

Input: arr[] = [0, 10, 20]
Output: -1
Explanation: we cannot jump forward from the beginning because arr[0]=0.
*/